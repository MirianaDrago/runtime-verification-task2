package larva;


import java.util.LinkedHashMap;
import java.io.PrintWriter;

public class _cls_AlertsFSM0 implements _callable{

public static PrintWriter pw; 
public static _cls_AlertsFSM0 root;

public static LinkedHashMap<_cls_AlertsFSM0,_cls_AlertsFSM0> _cls_AlertsFSM0_instances = new LinkedHashMap<_cls_AlertsFSM0,_cls_AlertsFSM0>();
static{
try{
RunningClock.start();
pw = new PrintWriter("/home/localhost/software-testing-part2/src/main/output_AlertsFSM.txt");

root = new _cls_AlertsFSM0();
_cls_AlertsFSM0_instances.put(root, root);
  root.initialisation();
}catch(Exception ex)
{ex.printStackTrace();}
}

_cls_AlertsFSM0 parent; //to remain null - this class does not have a parent!
public static boolean valid_properties;
int no_automata = 1;
 public int alerts =0 ;

public static void initialize(){}
//inheritance could not be used because of the automatic call to super()
//when the constructor is called...we need to keep the SAME parent if this exists!

public _cls_AlertsFSM0() {
}

public void initialisation() {
}

public static _cls_AlertsFSM0 _get_cls_AlertsFSM0_inst() { synchronized(_cls_AlertsFSM0_instances){
 return root;
}
}

public boolean equals(Object o) {
 if ((o instanceof _cls_AlertsFSM0))
{return true;}
else
{return false;}
}

public int hashCode() {
return 0;
}

public void _call(String _info, int... _event){
synchronized(_cls_AlertsFSM0_instances){
_performLogic_AlertProperty(_info, _event);
}
}

public void _call_all_filtered(String _info, int... _event){
}

public static void _call_all(String _info, int... _event){

_cls_AlertsFSM0[] a = new _cls_AlertsFSM0[1];
synchronized(_cls_AlertsFSM0_instances){
a = _cls_AlertsFSM0_instances.keySet().toArray(a);}
for (_cls_AlertsFSM0 _inst : a)

if (_inst != null) _inst._call(_info, _event);
}

public void _killThis(){
try{
if (--no_automata == 0){
synchronized(_cls_AlertsFSM0_instances){
_cls_AlertsFSM0_instances.remove(this);}
}
else if (no_automata < 0)
{throw new Exception("no_automata < 0!!");}
}catch(Exception ex){ex.printStackTrace();}
}

int _state_id_AlertProperty = 59;

public void _performLogic_AlertProperty(String _info, int... _event) {

_cls_AlertsFSM0.pw.println("[AlertProperty]AUTOMATON::> AlertProperty("+") STATE::>"+ _string_AlertProperty(_state_id_AlertProperty, 0));
_cls_AlertsFSM0.pw.flush();

if (0==1){}
else if (_state_id_AlertProperty==59){
		if (1==0){}
		else if ((_occurredEvent(_event,114/*alertCreated*/))){
		alerts ++;
_cls_AlertsFSM0.pw .println ("Alert created");

		_state_id_AlertProperty = 59;//moving to state viewAlerts
		_goto_AlertProperty(_info);
		}
		else if ((_occurredEvent(_event,116/*deleteAlerts*/))){
		alerts =0 ;
_cls_AlertsFSM0.pw .println ("Alerts were deleted");

		_state_id_AlertProperty = 59;//moving to state viewAlerts
		_goto_AlertProperty(_info);
		}
		else if ((_occurredEvent(_event,112/*checkAlerts*/))){
		alerts <=5 &&valid_properties ==true ;
_cls_AlertsFSM0.pw .println ("Alerts are valid");

		_state_id_AlertProperty = 57;//moving to state goodState
		_goto_AlertProperty(_info);
		}
		else if ((_occurredEvent(_event,112/*checkAlerts*/))){
		alerts >5 &&valid_properties ==false ;
_cls_AlertsFSM0.pw .println ("Alerts are invalid");

		_state_id_AlertProperty = 56;//moving to state badState
		_goto_AlertProperty(_info);
		}
}
}

public void _goto_AlertProperty(String _info){
_cls_AlertsFSM0.pw.println("[AlertProperty]MOVED ON METHODCALL: "+ _info +" TO STATE::> " + _string_AlertProperty(_state_id_AlertProperty, 1));
_cls_AlertsFSM0.pw.flush();
}

public String _string_AlertProperty(int _state_id, int _mode){
switch(_state_id){
case 56: if (_mode == 0) return "badState"; else return "!!!SYSTEM REACHED BAD STATE!!! badState "+new _BadStateExceptionAlertsFSM().toString()+" ";
case 59: if (_mode == 0) return "viewAlerts"; else return "viewAlerts";
case 57: if (_mode == 0) return "goodState"; else return "goodState";
default: return "!!!SYSTEM REACHED AN UNKNOWN STATE!!!";
}
}

public boolean _occurredEvent(int[] _events, int event){
for (int i:_events) if (i == event) return true;
return false;
}
}