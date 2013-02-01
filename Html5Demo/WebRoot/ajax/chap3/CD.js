CD = Class.create();

CD.prototype = Object.extend(
  new Disc(),
  {

    initialize: function(title,artist,location) {
      this._initializeDisc(title,location,'CD');
      this._mymethod1();
      this.artist = artist;
    }

  }
);
