var Validator = Class.create();

Validator.prototype = {
  type: "all",

  initialize: function(validators) {                          
    validators[this.type] = this;  //  此方法被子类继承，当new本类的时候 会将传进来的validators对象进行设置值指向本引用;
  },

  doValidate: function(input) {                              
    return "";
  },

  validate: function(input, errordiv) {                       
    errorMsg = this.doValidate(input);
    errordiv.innerHTML = errorMsg;
    return (errorMsg.length == 0);  //如果为空串 那么就是true
  }
};

var NumberValidator = Class.create();   //扩展性良好

Object.extend(NumberValidator.prototype,Validator.prototype); //先将Validator的内容给继承了,

Object.extend(NumberValidator.prototype, {			//然后再声明属于自己的一些属性和方法
    type: "number",                                           

     doValidate: function(input) {                            
      var numberpattern=/(^\d+$)|(^\d+\.\d+$)/;
      if (numberpattern.test(input)) {
        return "";
      } else {
        return "'" + input + "' is not a number." ;
      }
    }
});

var ValidatorFramework = Class.create();

ValidatorFramework.prototype =
{
  validators: 0, 
  
  initialize: function() {                     //用来初始话validators map对象的值的               
	    this.validators = new Object();
	    new Validator(this.validators);   //传的是引用，所以值可以保存下来;
	    new NumberValidator(this.validators);
	  },
	  

	  validateForm : function(form) {
		var retval = true;
		if (form.length > 1) {
			for ( var i = 0; i < form.length; i++) {
				currentInput = form[i];
				// alert(currentInput.id);
				type = currentInput.getAttribute("valid");
				errorDivName = currentInput.getAttribute("error");
				if (type == null || errorDivName == null) {
					continue;
				} else {
					valid = this.validate(type, currentInput.value,
							$(errorDivName));
					if (!valid) {
						retval = false;
					}
				}
			}
		} else {
			type = form.getAttribute("valid");
			errorDivName = form.getAttribute("error");
			valid = this.validate(type, form.value, $(errorDivName));
			if (!valid) {
				retval = false;
			}
		}
		return retval;
	},

  validate: function(type, input, errordiv) {
	  return this.validators[type].validate(input, errordiv);                              
  }
  
}