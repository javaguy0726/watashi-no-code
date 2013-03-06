/* ************************************************************************

   qooxdoo - the new era of web interface development

   Copyright:
     (C) 2004-2006 by Schlund + Partner AG, Germany
         All rights reserved

   License:
     LGPL 2.1: http://creativecommons.org/licenses/LGPL/2.1/

   Internet:
     * http://qooxdoo.oss.schlund.de

   Authors:
     * Sebastian Werner (wpbasti)
       <sebastian dot werner at 1und1 dot de>
     * Andreas Ecker (aecker)
       <andreas dot ecker at 1und1 dot de>

************************************************************************ */

/* ************************************************************************

#package(toolbar)

************************************************************************ */

function QxToolBarSeparator()
{
  QxCanvasLayout.call(this);

  var l = new QxTerminator;
  l.setAppearance("toolbar-separator-line");
  this.add(l);
};

QxToolBarSeparator.extend(QxCanvasLayout, "QxToolBarSeparator");

QxToolBarSeparator.changeProperty({ name : "appearance", type : QxConst.TYPEOF_STRING, defaultValue : "toolbar-separator" });