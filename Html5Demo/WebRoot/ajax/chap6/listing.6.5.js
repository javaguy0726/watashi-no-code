var Validator = Class.create();

Validator.prototype = {
	type : "all",

	initialize : function(validators) {   //注册常规验证这块
		validators[this.type] = this;
	},

	doValidate : function(input) { 
		return "";
	},

	validate : function(input, errordiv) {  
		errorMsg = this.doValidate(input);
		errordiv.innerHTML = errorMsg;
		return (errorMsg.length == 0);
	},
	
}

var NumberValidator = Class.create();

Object.extend(NumberValidator.prototype, Validator.prototype);

Object.extend(NumberValidator.prototype, {
	type : "number",  

	doValidate : function(input) { 
		var numberpattern = /(^\d+$)|(^\d+\.\d+$)/;
		if (numberpattern.test(input)) {
			return "";
		} else {
			return "'" + input + "' is not a number.";
		}
	}
});

var DateValidator = Class.create();  
Object.extend(DateValidator.prototype, Validator.prototype);
Object.extend(DateValidator.prototype, {
	type : "date",

	doValidate : function(input) {
		var value = Date.parse(input);  
		if (value <= 0) {
			return "'" + input + "' is not a date.";
		} else {
			return "";
		}
	}
});

var ValidatorFramework = Class.create();
ValidatorFramework.prototype = {
	validators : 0,
	crossValidators : 0,  

	initialize : function() {
		this.validators = new Array();
		this.crossValidators = new Array();

		new Validator(this.validators);
		new NumberValidator(this.validators);
		new DateValidator(this.validators);
	},
	
	validateForm : function(form) {
		var retval = true;
		for (var i = 0; i < form.length; i++) {
			currentInput = form[i];
			type = currentInput.getAttribute("valid");
			errorDivName = currentInput.getAttribute("error");
			if (type == null || errorDivName == null) {
				continue;
			} else {
				valid = this.validate(type, currentInput.value, $(errorDivName)); //增加了一个date验证，
				if (!valid) {
					retval = false;
				}
				else{
					$(errorDivName).innerHTML="";
				}
			}
		}
		
		for (var i = 0;  i < this.crossValidators.length; i++) {
			this.crossValidators[i].clearErrors();
		}
		
		if (retval) {  
			for (i = 0; i < this.crossValidators.length; i++) {
				valid = this.crossValidators[i].validate();
				if (!valid) {
					retval = false;
				}
			}
		}
		return retval;
	},

	validate : function(type, input, errordiv) {
		var validator = this.validators[type];
		if (!validator) {
			alert("No validator for type '" + type + "'.");
			return "";
		}
		return validator.validate(input, errordiv);
	}

}

var CrossValidator = Class.create(); 
Object.extend(CrossValidator.prototype, {
	type : "none",
	crossInputs : 0,
	crossError : 0,

	initialize : function(framework, p_crossInputs, p_crossError) { 
		    framework.crossValidators.push(this); 
	        this.crossInputs = p_crossInputs;
	        this.crossError = p_crossError;    //实际调用 new DateRangeCrossValidator(framework,new Array($('start'),$('end')),$('startend_err'));
	},

	validate : function() {
		errorMsg = this.doValidate(this.crossInputs); 
		this.crossError.innerHTML = errorMsg;
		return (errorMsg.length == 0);
	},

	clearErrors : function() { 
		this.crossError.innerHTML = "";
	}
});

var DateRangeCrossValidator = Class.create(); 
Object.extend(DateRangeCrossValidator.prototype, CrossValidator.prototype);
Object.extend(DateRangeCrossValidator.prototype, {

	doValidate : function(inputs) {      						//$('start'),$('end')
		var startDate = Date.parse(inputs[0].value);
		var endDate = Date.parse(inputs[1].value);
		if (startDate > endDate) {
			return "The start date cannot be after the end date.";
		} else {
			return "";
		}
	}

});
