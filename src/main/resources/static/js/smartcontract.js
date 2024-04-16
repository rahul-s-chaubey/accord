import { ethers } from "./ethers.js";


	 var customerdet = document.getElementById("customerdet");
        var customerdetcontainer = document.getElementById("customerdetcontainer");
        var bankdet = document.getElementById("bankdet");
        var bankdetcontainer = document.getElementById("bankdetcontainer");
        var loandet = document.getElementById("loandet");
        var loandetcontainer = document.getElementById("loandetcontainer");
        var cardet = document.getElementById("cardet");
        var cardetcontainer = document.getElementById("cardetcontainer");



		customerdet.onclick = function () {
          if (customerdetcontainer.style.display === "none" || customerdetcontainer.style.display === "") {
            customerdetcontainer.style.display = "grid"; // Show the div
          } else {
            customerdetcontainer.style.display = "none"; // Hide the div
          }
        };
        
        bankdet.onclick = function () {
          if (bankdetcontainer.style.display === "none" || bankdetcontainer.style.display === "") {
            bankdetcontainer.style.display = "grid"; // Show the div
          } else {
            bankdetcontainer.style.display = "none"; // Hide the div
          }
        };

		loandet.onclick = function () {
          if (loandetcontainer.style.display === "none" || loandetcontainer.style.display === "") {
            loandetcontainer.style.display = "grid"; // Show the div
          } else {
            loandetcontainer.style.display = "none"; // Hide the div
          }
        };
        
        cardet.onclick = function () {
          if (cardetcontainer.style.display === "none" || cardetcontainer.style.display === "") {
            cardetcontainer.style.display = "grid"; // Show the div
          } else {
            cardetcontainer.style.display = "none"; // Hide the div
          }
        };


let contractAddress = "0xcdfe4977195feb79cfde8cde999bb9864c665733";

const smartContractButton = document.getElementById("callContract");

const contractAbi = [
	{
		"inputs": [
			{
				"internalType": "string",
				"name": "_customerName",
				"type": "string"
			},
			{
				"internalType": "string",
				"name": "_dealerName",
				"type": "string"
			},
			{
				"internalType": "string",
				"name": "_bankName",
				"type": "string"
			},
			{
				"internalType": "string",
				"name": "_amount",
				"type": "string"
			},
			{
				"internalType": "string",
				"name": "_date",
				"type": "string"
			}
		],
		"name": "setString",
		"outputs": [],
		"stateMutability": "nonpayable",
		"type": "function"
	},
	{
		"inputs": [],
		"name": "amount",
		"outputs": [
			{
				"internalType": "string",
				"name": "",
				"type": "string"
			}
		],
		"stateMutability": "view",
		"type": "function"
	},
	{
		"inputs": [],
		"name": "bankName",
		"outputs": [
			{
				"internalType": "string",
				"name": "",
				"type": "string"
			}
		],
		"stateMutability": "view",
		"type": "function"
	},
	{
		"inputs": [],
		"name": "customerName",
		"outputs": [
			{
				"internalType": "string",
				"name": "",
				"type": "string"
			}
		],
		"stateMutability": "view",
		"type": "function"
	},
	{
		"inputs": [],
		"name": "date",
		"outputs": [
			{
				"internalType": "string",
				"name": "",
				"type": "string"
			}
		],
		"stateMutability": "view",
		"type": "function"
	},
	{
		"inputs": [],
		"name": "dealerName",
		"outputs": [
			{
				"internalType": "string",
				"name": "",
				"type": "string"
			}
		],
		"stateMutability": "view",
		"type": "function"
	},
	{
		"inputs": [],
		"name": "getString",
		"outputs": [
			{
				"internalType": "string",
				"name": "",
				"type": "string"
			}
		],
		"stateMutability": "view",
		"type": "function"
	},
	{
		"inputs": [],
		"name": "result",
		"outputs": [
			{
				"internalType": "string",
				"name": "",
				"type": "string"
			}
		],
		"stateMutability": "view",
		"type": "function"
	}
];


const _customerName = "ankita";
const _dealerName = "rahul";
const _bankName = "IDBI";
const _amount = "100";
const _date = "03/04/24"


smartContractButton.addEventListener("click", function() {

	if (window.ethereum && window.ethereum.isMetaMask) {
		window.ethereum
			.request({ method: "eth_requestAccounts" })
			.then((result) => {
				console.log(result);
				return updateEthers();
			})
			/*.then(value => {
				console.log(value);
				return setCurrentVal(value)
			})*/
			.then(value => {
				console.log(value);
				return getCurrentVal(value)
			})
			.then(value => {
				console.log("smart contract: " + value); alert("smart contract reply: " + value);
				fetchAndOpenPDF(value);

			})
			.catch((error) => {
				console.log(error.message);
			});
	}

});



function updateEthers() {
	let tempProvider = new ethers.providers.Web3Provider(window.ethereum);
	let tempSigner = tempProvider.getSigner();
	let tempContract = new ethers.Contract(
		contractAddress,
		contractAbi,
		tempSigner

	);

	const etherObj = {
		provider: tempProvider,
		signer: tempSigner,
		contract: tempContract,
	}

	return new Promise((resolve, reject) => {
		resolve(etherObj);
	});
}


async function getCurrentVal({ contract }) {


	let value = await contract.getString();
	console.log(value);
	return new Promise((resolve, reject) => {
		resolve(value);
	});
}



function setCurrentVal({ contract }) {


	let value = contract.setString(_customerName, _dealerName, _bankName, _amount, _date)

	console.log(value);

	return new Promise((resolve, reject) => {
		resolve(contract);
	});
}





function fetchAndOpenPDF(value) {

	const formData = new FormData(carloanform);
	formData.append("smartcontracturul", value);


	fetch('http://localhost:8080/api/viewcarloanPdf', {
		method: 'POST',
		body: formData,
	})
		.then(response => response.blob())
		.then(blob => {
			const pdfUrl = URL.createObjectURL(blob);
			window.open(pdfUrl, '_blank');
			URL.revokeObjectURL(pdfUrl);
		})
		.catch(error => {
			console.error('Error fetching PDF:', error);
		});
}

