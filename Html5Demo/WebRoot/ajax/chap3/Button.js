function Button(elementName, options) {
    this.element = document.getElementById(elementName);
    //Button对象的element对象成员为页面button元素
    if (!this.element)
        throw new Error(elementName + ' not found');
    this.element.button = this;
    //                   添加一个自引用，保存啦Button对象的实例到成員element.button中
    this.options = options || {};
    //hash参数

    if (options) {
        this.options.enabled = options.enabled || true;
        this.options.onClick = options.onClick ||
        function() {
        };
        this.options.enabledClassName = options.enabledClassName || this.CLASS_DEFAULT_CLASS_ENABLED;
        this.options.disabledClassName = options.disabledClassName || this.CLASS_DEFAULT_CLASS_DISABLED;
        this.options.armedClassName = options.armedClassName || this.CLASS_DEFAULT_CLASS_ARMED;
        this.options.pressedClassName = options.pressedClassName || this.CLASS_DEFAULT_CLASS_PRESSED;
    }

    //Set the constant variable.
    Button.prototype.CLASS_DEFAULT_CLASS_ENABLED = 'buttonEnabled';
    Button.prototype.CLASS_DEFAULT_CLASS_ARMED = 'buttonArmed';
    Button.prototype.CLASS_DEFAULT_CLASS_DISABLED = 'buttonDisabled';
    Button.prototype.CLASS_DEFAULT_CLASS_PRESSED = 'buttonPressed';

    //将Button实例存到变量中，因爲閉包創建時不包含函數的上下文 即this
    //加入使用的不是instance而是this,那麼結果會等同於調用element.options.xx, 這顯然不對
    var instance = this;
    this.element.onclick = function() {//  - 4
        if (instance.options.enabled) {
            instance.options.onClick.call(instance);
        }
        
    };
    
    //改造成自引用的方式
   /* this.element.onclick = function(){
    	if(this.button.options.enabled){
    		this.button.options.onClick.call(this.button);
    	}
    }*/
    
    this.element.onmouseover = this.onArm;
    this.element.onmouseout = this.onDisarm;
    this.element.onmousedown = this.onPress;
    this.element.onmouseup = this.onRelease;
   
    if (this.options.enabled) {
        this.enable();
    } else {
        this.disable();
    }
}

Button.prototype.onArm = function() {
    if (this.button.options.enabled) {
        this.className = this.button.options.armedClassName;
    }
};

Button.prototype.onDisarm = function() {
    if (this.button.options.enabled) {
        this.className = this.button.options.enabledClassName;
    }
};

Button.prototype.onPress = function() {
    if (this.button.options.enabled) {
        this.className = this.button.options.pressedClassName;
    }
};

Button.prototype.onRelease = function() {
    if (this.button.options.enabled) {
        this.className = this.button.options.enabledClassName;
    }
};

Button.prototype.isEnabled = function() {
    return this.options.enabled;
};

Button.prototype.enable = function() {
    this.options.enabled = true;
    this.element.disabled = false;
    this.element.className = this.options.enabledClassName;
};

Button.prototype.disable = function() {
    this.options.enabled = false;
    this.element.disabled = true;
    this.element.className = this.options.disabledClassName;
};