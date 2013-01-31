/**
 * Providing some util functions.
 */

//加载外部js文件
function load_external_script(url) {
	var script = document.createElement("script");
	script.type = "text/javascript";
	script.src = url;
	document.body.appendChild(script);
}

//加载内部js代码
function load_internal_script(code) {
	var script = document.createElement("script");
	script.type = "text/javascript";
	try {
		script.appendChild(document.createTextNode(code));
	} catch (ex) {
		script.text = code;
	}
	document.body.appendChild(script);
}

//加载外部css
function load_external_style(url) {
	var link = document.createElement("link");
	link.rel = "stylesheet";
	link.type = "text/css";
	link.href = url;
	var head = document.getElementsByTagName("head")[0];
	head.appendChild(link);
}

//加载内部css
function load_internal_style(code) {
	var style = document.createElement("style");
	style.type = "text/css";
	try {
		style.appendChild(document.createTextNode(code));
	} catch (ex) {
		style.stylesheet.cssText = code;
	}
	var head = document.getElementsByTagName("head")[0];
	head.appendChild(style);
}

function string_trim(){
	String.prototype.trim = function(){
		var matches = this.match(/^[\t\n\r]+/);
		var preLength = (matches==null)?0:matches[0].length;
		var matches = this.match(/[\t\n\r]+$/);
		var sufLength = (matches==null)?0:matches[0].length;
		return this.slice(preLength, this.length-sufLength);
	};
}