package aspects;

import larva.*;
public aspect _asp_LoginFSM0 {

public static Object lock = new Object();

boolean initialized = false;

after():(staticinitialization(*)){
if (!initialized){
	initialized = true;
	_cls_LoginFSM0.initialize();
}
}
before () : (call(* *.LogOut(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_LoginFSM0.lock){

_cls_LoginFSM0 _cls_inst = _cls_LoginFSM0._get_cls_LoginFSM0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 110/*LogOut*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 110/*LogOut*/);
}
}
before () : (call(* *.goodLogin(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_LoginFSM0.lock){

_cls_LoginFSM0 _cls_inst = _cls_LoginFSM0._get_cls_LoginFSM0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 106/*goodLogin*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 106/*goodLogin*/);
}
}
before () : (call(* *.visitAlerts(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_LoginFSM0.lock){

_cls_LoginFSM0 _cls_inst = _cls_LoginFSM0._get_cls_LoginFSM0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 108/*visitAlerts*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 108/*visitAlerts*/);
}
}
before () : (call(* *.badLogin(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_LoginFSM0.lock){

_cls_LoginFSM0 _cls_inst = _cls_LoginFSM0._get_cls_LoginFSM0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 104/*badLogin*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 104/*badLogin*/);
}
}
}