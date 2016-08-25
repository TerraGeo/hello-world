var numberInputOne = '',
	signValue,
	doc = document;

function insertNumber(domElement){
	
		if(doc.getElementById("reverseString").value.length < 9){
		var numberInputOne = doc.getElementById("reverseString").value.concat(domElement.value);
		doc.getElementById("reverseString").value = numberInputOne;
		}
};

function insertSign(domElement){
		
		if((domElement.value === "+") || (domElement.value === "-") || (domElement.value === "*") || (domElement.value === "/")){
			this.numberInputOne = doc.getElementById("reverseString").value;
			doc.getElementById("reverseString").value = "";
			signValue = domElement.value;
		}
};

function execute(){
	var destinationNumber = doc.getElementById("reverseString").value;
	doc.getElementById("reverseString").value = eval(`${numberInputOne}${signValue}${destinationNumber}`);
};

function clearAll() {
	if(doc.getElementById("cleaner").value === "AC"){
		this.numberInputOne = doc.getElementById("reverseString").value;
		doc.getElementById("reverseString").value = "";
	}

};

function percentageCounter() {
	if(doc.getElementById("percentSign").value === "%"){
		var destinationNumber = doc.getElementById("reverseString").value;
		doc.getElementById("reverseString").value = Number((doc.getElementById("reverseString").value) / 100);
	}
};

function signSwitcher() {
	if(doc.getElementById("signChange").value === "+/-"){
		this.numberInputOne = doc.getElementById("reverseString").value;
		doc.getElementById("reverseString").value = -doc.getElementById("reverseString").value;
	}
};


