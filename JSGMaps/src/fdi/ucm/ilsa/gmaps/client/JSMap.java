/**
 * 
 */
package fdi.ucm.ilsa.gmaps.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Panel;

import fdi.ucm.server.interconect.model.DocumentCompleteJSON;

/**
 * @author Joaquin Gayoso-Cabada
 *
 */
public class JSMap {

	private DocumentCompleteJSON Documento;
	private String RandomIdVars;

	public JSMap(String randomIdVars, long contextId, int height, boolean isgrammar) {
		Documento=getVariableBase(randomIdVars);
		RandomIdVars=randomIdVars;
		Panel Princilpal=getContextDiv(RandomIdVars);
		
		Princilpal.add(new Label("Estoy Aqui"));
	}
	
	
	public static native Panel getContextDiv(String ContextID) /*-{

	$wnd.daletmp = '$wnd.dale = $wnd.VDocExpand'+ContextID;
	eval($wnd.daletmp)
	  return  $wnd.dale;

	}-*/;

	public void persistJS() {
		GWT.log(Documento.toString());
		setVariableBase(Documento,RandomIdVars);
		
	}
	
	public static native DocumentCompleteJSON getVariableBase(String documentID2) /*-{
	$wnd.daletmp = '$wnd.dale = $wnd.DocExpand'+documentID2;
eval($wnd.daletmp)
  return  $wnd.dale;	  

}-*/;
	
	
	public static native void setVariableBase(DocumentCompleteJSON DocumentoExpandido, String idrandomdoct) /*-{


	$wnd.tmp=DocumentoExpandido;
	$wnd.str = '$wnd.DocExpand'+idrandomdoct +' = $wnd.tmp';
	console.log($wnd.str);
	eval($wnd.str)

	}-*/;

}
