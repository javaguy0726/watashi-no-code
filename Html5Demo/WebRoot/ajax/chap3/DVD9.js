DVD9 = Class.create();

DVD9.prototype = Object.extend(
		  new DVD(),
		  {
		    initialize: function(title,director,location,singer) {
		      this._initializeDisc(title,location,'DVD');
		      this._initializeDVD();
		    },
		   
		    _initializeDVD: function(){
		    	this.singer='Watashi';
		    }
		    
		  }
		);