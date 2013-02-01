DVD = Class.create();

DVD.prototype = Object.extend(
  new Disc(),
  {
    initialize: function(title,director,location,singer) {
      this._initializeDisc(title,location,'DVD');
      this._initializeDVD(singer);
    },
  
    _initializeDVD: function(singer){
    	this.singer=singer;
    },
    
    whereIsIt : function() {
		return 'The ' + this.type + ' titled ' + this.title + ' is on shelf '
				+ this.location+' singer  '+this.singer;
	}
  }
);
