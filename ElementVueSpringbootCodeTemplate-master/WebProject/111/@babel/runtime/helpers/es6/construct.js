import _Reflect$construct from "../../core-js/reflect/construct";
import setPrototypeOf from "./setPrototypeOf";
export default function _construct(Parent, args, Class) {
  if (typeof Reflect !== "undefined" && _Reflect$construct) {
    _construct = _Reflect$construct;
  } else {
    _construct = function _construct(Parent, args, Class) {
      var a = [null];
      a.push.apply(a, args);
      var Constructor = Parent.bind.apply(Parent, a);
      var instance = new Constructor();
      if (Class) setPrototypeOf(instance, Class.prototype);
      return instance;
    };
  }

  return _construct.apply(null, arguments);
}