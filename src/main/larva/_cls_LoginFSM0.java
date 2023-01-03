package larva;


import java.util.LinkedHashMap;
import java.io.PrintWriter;

public class _cls_LoginFSM0 implements _callable{

public static PrintWriter pw; 
public static _cls_LoginFSM0 root;

public static LinkedHashMap<_cls_LoginFSM0,_cls_LoginFSM0> _cls_LoginFSM0_instances = new LinkedHashMap<_cls_LoginFSM0,_cls_LoginFSM0>();
static{
try{
RunningClock.start();
pw = new PrintWriter("/home/localhost/software-testing-part2/src/main/output_LoginFSM.txt");

root = new _cls_LoginFSM0();
_cls_LoginFSM0_instances.put(root, root);
  root.initialisation();
}catch(Exception ex)
{ex.printStackTrace();}
}

_cls_LoginFSM0 parent; //to remain null - this class does not have a parent!
int no_automata = 1;
 public boolean loggedIn =false ;
 public boolean inAlertsPage =false ;
 public boolean valid_credentials =false ;

public static void initialize(){}
//inheritance could not be used because of the automatic call to super()
//when the constructor is called...we need to keep the SAME parent if this exists!

public _cls_LoginFSM0() {
}

public void initialisation() {
}

public static _cls_LoginFSM0 _get_cls_LoginFSM0_inst() { synchronized(_cls_LoginFSM0_instances){
 return root;
}
}

public boolean equals(Object o) {
 if ((o instanceof _cls_LoginFSM0))
{return true;}
else
{return false;}
}

public int hashCode() {
return 0;
}

public void _call(String _info, int... _event){
synchronized(_cls_LoginFSM0_instances){
_performLogic_LoginProperty(_info, _event);
}
}

public void _call_all_filtered(String _info, int... _event){
}

public static void _call_all(String _info, int... _event){

_cls_LoginFSM0[] a = new _cls_LoginFSM0[1];
synchronized(_cls_LoginFSM0_instances){
a = _cls_LoginFSM0_instances.keySet().toArray(a);}
for (_cls_LoginFSM0 _inst : a)

if (_inst != null) _inst._call(_info, _event);
}

public void _killThis(){
try{
if (--no_automata == 0){
synchronized(_cls_LoginFSM0_instances){
_cls_LoginFSM0_instances.remove(this);}
}
else if (no_automata < 0)
{throw new Exception("no_automata < 0!!");}
}catch(Exception ex){ex.printStackTrace();}
}

int _state_id_LoginProperty = 55;

public void _performLogic_LoginProperty(String _info, int... _event) {

_cls_LoginFSM0.pw.println("[LoginProperty]AUTOMATON::> LoginProperty("+") STATE::>"+ _string_LoginProperty(_state_id_LoginProperty, 0));
_cls_LoginFSM0.pw.flush();

if (0==1){}
else if (_state_id_LoginProperty==54){
		if (1==0){}
		else if ((_occurredEvent(_event,108/*visitAlerts*/))){
		inAlertsPage ==true ;

		_state_id_LoginProperty = 54;//moving to state viewAlerts
		_goto_LoginProperty(_info);
		}
		else if ((_occurredEvent(_event,110/*LogOut*/))){
		loggedIn =false &&inAlertsPage ==false ;
_cls_LoginFSM0.pw .println ("User logged out");

		_state_id_LoginProperty = 55;//moving to state LoggedOut
		_goto_LoginProperty(_info);
		}
}
else if (_state_id_LoginProperty==55){
		if (1==0){}
		else if ((_occurredEvent(_event,104/*badLogin*/))){
		loggedIn ==false &&valid_credentials ==false ;
_cls_LoginFSM0.pw .println ("User was unable to login. Credentials are invalid");

		_state_id_LoginProperty = 55;//moving to state LoggedOut
		_goto_LoginProperty(_info);
		}
		else if ((_occurredEvent(_event,106/*goodLogin*/))){
		loggedIn =true &&valid_credentials ==true ;
_cls_LoginFSM0.pw .println ("User logged in");

		_state_id_LoginProperty = 53;//moving to state LoggedIn
		_goto_LoginProperty(_info);
		}
}
else if (_state_id_LoginProperty==53){
		if (1==0){}
		else if ((_occurredEvent(_event,108/*visitAlerts*/))){
		loggedIn ==true &&inAlertsPage ==true ;
_cls_LoginFSM0.pw .println ("User viewed alerts");

		_state_id_LoginProperty = 54;//moving to state viewAlerts
		_goto_LoginProperty(_info);
		}
		else if ((_occurredEvent(_event,110/*LogOut*/))){
		loggedIn ==false ;
_cls_LoginFSM0.pw .println ("User logged out");

		_state_id_LoginProperty = 55;//moving to state LoggedOut
		_goto_LoginProperty(_info);
		}
}
}

public void _goto_LoginProperty(String _info){
_cls_LoginFSM0.pw.println("[LoginProperty]MOVED ON METHODCALL: "+ _info +" TO STATE::> " + _string_LoginProperty(_state_id_LoginProperty, 1));
_cls_LoginFSM0.pw.flush();
}

public String _string_LoginProperty(int _state_id, int _mode){
switch(_state_id){
case 54: if (_mode == 0) return "viewAlerts"; else return "viewAlerts";
case 55: if (_mode == 0) return "LoggedOut"; else return "LoggedOut";
case 53: if (_mode == 0) return "LoggedIn"; else return "LoggedIn";
default: return "!!!SYSTEM REACHED AN UNKNOWN STATE!!!";
}
}

public boolean _occurredEvent(int[] _events, int event){
for (int i:_events) if (i == event) return true;
return false;
}
}