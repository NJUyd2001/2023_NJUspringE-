function _inheritsLoose(subClass, superClass) {
  subClass.prototype.__proto__ = superClass && superClass.prototype;
  subClass.__proto__ = superClass;
}

module.exports = _inheritsLoose;