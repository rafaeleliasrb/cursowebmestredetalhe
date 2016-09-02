package br.com.cursowebmestredetalhe.adapter;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.xml.bind.annotation.adapters.XmlAdapter;

public class DateAdapter extends XmlAdapter<String, Date> {

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	@Override
	public Date unmarshal(String value) throws Exception {
		if(value != null && !value.isEmpty()) {
			return sdf.parse(value);
		}
		return null;
	}

	@Override
	public String marshal(Date value) throws Exception {
		if(value != null) {
			return sdf.format(value);
		}
		return "";
	}
}