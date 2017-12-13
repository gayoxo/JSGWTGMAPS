package fdi.ucm.ilsa.gmaps.client;

import java.util.ArrayList;

import com.google.gwt.core.client.Duration;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

import fdi.ucm.server.interconect.model.DocumentCompleteJSON;
import fdi.ucm.server.interconect.model.DocumentsJSON;
import fdi.ucm.server.interconect.model.GrammarJSON;
import fdi.ucm.server.interconect.model.OperationalValueJSON;



/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class JSGMaps implements EntryPoint {
	
	private final static String iconvalue="gmaps.png";
	private static JSMap JSMAPElement;
	
	static {
        export();
    }
	
	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		//TODO
		/*
		 * -Crea unas 
		 */
		
		DocumentsJSON DJ=new DocumentsJSON(01l, "coordenadasTest", "", 01l, new ArrayList<Long>(), new ArrayList<OperationalValueJSON>(), "");
		
		ArrayList<GrammarJSON> grammars=new ArrayList<GrammarJSON>();
		
		
		DocumentCompleteJSON text=new DocumentCompleteJSON(DJ,grammars);
		
		RootPanel RT=RootPanel.get();
		
		VerticalPanel EjemploPanel=new VerticalPanel();
		
		RT.add(EjemploPanel);
		
		String RandomIdVars = Long.toString(Math.abs(Math.round(Double.valueOf(Duration.currentTimeMillis()))));
		
		
		setContextDiv(EjemploPanel, RandomIdVars);
		setVariableBase(text, RandomIdVars);
		
	}

	 private static native void export() /*-{
     $wnd.JSGMapsgetIconData = @fdi.ucm.ilsa.gmaps.client.JSGMaps::getIcon();
     $wnd.JSGMapsgetParamData = @fdi.ucm.ilsa.gmaps.client.JSGMaps::getIcon();
     $wnd.JSGMapssetContextView = @fdi.ucm.ilsa.gmaps.client.JSGMaps::setContextView(Ljava/lang/String;Ljava/lang/Long;IZ);
     $wnd.JSGMapssetContextEdit = @fdi.ucm.ilsa.gmaps.client.JSGMaps::setContextView(Ljava/lang/String;Ljava/lang/Long;IZ);
     $wnd.JSGMapspersist = @fdi.ucm.ilsa.gmaps.client.JSGMaps::persistJS();
 }-*/;
	 
	 
	 public static native void setVariableBase(DocumentCompleteJSON DocumentoExpandido, String idrandomdoct) /*-{
		
		
		$wnd.tmp=DocumentoExpandido;
		$wnd.str = '$wnd.DocExpand'+idrandomdoct +' = $wnd.tmp';
		console.log($wnd.str);
		eval($wnd.str)

	}-*/;
	
	public static native void setContextDiv(Panel context, String idrandomdoct) /*-{
	
	
	$wnd.tmp=context;
	$wnd.str = '$wnd.VDocExpand'+idrandomdoct +' = $wnd.tmp';
	console.log($wnd.str);
	eval($wnd.str)

}-*/;
	 
	 
	 private static String getIcon() {
	    	return iconvalue;
	    }
	 
	 private static void setContextView(String randomIdVars, Long contextId, int Height, boolean isgrammar) {
		  JSMAPElement=	new JSMap(randomIdVars,contextId,Height,isgrammar);
	    }
	 
	 public static void persistJS() {
		 JSMAPElement.persistJS();
		}
}
