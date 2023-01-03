package aspects;

import larva.*;
public aspect _asp_AlertsFSM0 {

public static Object lock = new Object();

boolean initialized = false;

after():(staticinitialization(*)){
if (!initialized){
	initialized = true;
	_cls_AlertsFSM0.initialize();
}
}
before () : (call(* *.alertCreated(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_AlertsFSM0.lock){

_cls_AlertsFSM0 _cls_inst = _cls_AlertsFSM0._get_cls_AlertsFSM0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 114/*alertCreated*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 114/*alertCreated*/);
}
}
before () : (call(* *.deleteAlerts(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_AlertsFSM0.lock){

_cls_AlertsFSM0 _cls_inst = _cls_AlertsFSM0._get_cls_AlertsFSM0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 116/*deleteAlerts*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 116/*deleteAlerts*/);
}
}
before ( boolean valid_properties) : (call(* *.checkAlerts(..)) && args(valid_properties,*) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_AlertsFSM0.lock){

_cls_AlertsFSM0 _cls_inst = _cls_AlertsFSM0._get_cls_AlertsFSM0_inst();
_cls_inst.valid_properties = valid_properties;
_cls_inst._call(thisJoinPoint.getSignature().toString(), 112/*checkAlerts*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 112/*checkAlerts*/);
}
}
}