Disc = Class.create();

Disc.prototype = {

	initialize : function(title, location, type) {
		this._initializeDisc(title, location, type);
		// this.title = title;
		// this.location = location;
		// this.type = type;
	},

	_initializeDisc : function(title, location, type) {
		this.title = title;
		this.location = location;
		this.type = type;
	},

	_mymethod1: function(){
	  document.write("My Method --!");	
	},
	
	whereIsIt : function() {
		return 'The ' + this.type + ' titled ' + this.title + ' is on shelf '
				+ this.location;
	}

}
