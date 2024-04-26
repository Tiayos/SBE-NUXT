package ups.edu.ups.sol.response;

import java.util.ArrayList;
import java.util.HashMap;


public class ResponseRestMetadata {

	private ArrayList<HashMap<String, String>>  metadata = new ArrayList<>();
	
	public ArrayList<HashMap<String, String>> getMetadata(){
		return metadata;
	}
	
	/*Agrega la informacion adicional que va al usuario*/
	public void agregarMetadata(String tipo, String codigo, String dato) {
		HashMap<String, String> mapa = new HashMap<String, String>();
		mapa.put("tipo", tipo);
		mapa.put("codigo", codigo);
		mapa.put("dato", dato);
		
		metadata.add(mapa);
	}

	public void agregarMetadataCab(String numero_pagina,String total_paginas, String numero_registros ) {
		HashMap<String, String> mapa = new HashMap<String, String>();
		mapa.put("numero_pagina", numero_pagina);
		mapa.put("total_paginas", total_paginas);
		mapa.put("numero_registros", numero_registros);
		mapa.put("registros_por_pagina", Integer.toString(5));
		metadata.add(mapa);
	}

}
