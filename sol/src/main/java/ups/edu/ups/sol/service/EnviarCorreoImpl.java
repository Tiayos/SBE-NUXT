package ups.edu.ups.sol.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ups.edu.ups.sol.dao.DocumentosSolicitadosDao;
import ups.edu.ups.sol.dao.SolSolicitudEventoDao;
import ups.edu.ups.sol.model.sbe.SbeDocumentoSolicitadoFicha;
import ups.edu.ups.sol.projection.FichaAmpliadaProjection;
import ups.edu.ups.sol.projection.ParametrosNotificacion;
import java.util.List;
import java.util.Objects;

@Service
public class EnviarCorreoImpl implements EnviarCorreoService {

	String title1 = "UNIVERSIDAD POLITÉCNICA SALESIANA";
	String title2 = "SISTEMA DE BIENESTAR UNIVERSITARIO";
	String asuntoEmail = "Sistema de Bienestar Universitario";
	String messageContent1 = "Estimado/a ";
	String nombreEstudiante = "Nombre completo del estudiante";
	String emailEstudiante;
	String numeroSolicitud= "Número de solicitud";
	String tipoSolicitud = "Tipo de solicitud";
	String descripcionTipoSolicitud;
	String solicitudFecha;
	String correoTrabajadorSocial, correoDirectorTecnico;
	String nombreTrabajadorSocial, nombreDirectorTecnico;
	String fechaFinalizacionFicha;
	String nivelBeca;
	String observacionSolicitud;
	Long periodoAplicaFicha;
	String projectStage = "DESARROLLO";

	@Autowired
	private JavaMailSender mailSender;

	@Autowired
	private SolSolicitudEventoDao solSolicitudEventoDao;

	@Autowired
	private DocumentosSolicitadosDao documentosSolicitadosDao;

	public void datosSolicitudEstudiante(String cedulaEstudiante, Long solCodigo){
		numeroSolicitud = null;
		tipoSolicitud = null;
		nombreEstudiante = null;
		correoTrabajadorSocial = null;
		nombreTrabajadorSocial = null;
		fechaFinalizacionFicha = null;

		//Obtiene el periodo vigente
		Integer pelCodigo = solSolicitudEventoDao.obtenerPeriodoLectivoVigente(cedulaEstudiante);

		//Obtiene la solicitud del estudiante
		ParametrosNotificacion parametrosNotificacion  = solSolicitudEventoDao.obtenerSolTisCodigo(pelCodigo, cedulaEstudiante, solCodigo);
		if( parametrosNotificacion != null ) {
			numeroSolicitud = parametrosNotificacion.getSolCodigo().toString();
			tipoSolicitud = parametrosNotificacion.getTipoSolicitudCodigo().toString();
			descripcionTipoSolicitud = parametrosNotificacion.getTipoSolicitudDescripcion();
			solicitudFecha = parametrosNotificacion.getSolicitudFecha();
			nombreEstudiante = parametrosNotificacion.getAluNombres() + " " + parametrosNotificacion.getAluApellidos();
			emailEstudiante = parametrosNotificacion.getAluEmail();
			correoTrabajadorSocial = parametrosNotificacion.getMaiDireccion();
			nombreTrabajadorSocial = parametrosNotificacion.getNombreTrabajadorSocial();
			correoDirectorTecnico = parametrosNotificacion.getMaiDirectorTecnico();
			nombreDirectorTecnico = parametrosNotificacion.getNombreDirectorTecnico();
			observacionSolicitud = parametrosNotificacion.getObservacionSolicitud();
			fechaFinalizacionFicha = solSolicitudEventoDao.obtenerFinFechaSolicitud(cedulaEstudiante);
			FichaAmpliadaProjection ficha = solSolicitudEventoDao.obtenerDatosFichaAmpliada(cedulaEstudiante);
			if (ficha != null){
				nivelBeca = ficha.getNivelBeca();
				periodoAplicaFicha = ficha.getPelCodigo();
			}
		}
	}

	public void sendEmailUsuario(String destinatario, String htmlContent) throws MessagingException {
		String destinatarioEmail = null;
		String copiaOcultaDestinatarioEmail = null;
		if (projectStage.equals("DESARROLLO")) {
			destinatarioEmail = "gsolano@ups.edu.ec";
			copiaOcultaDestinatarioEmail = "gina4389@gmail.com";
		} else if (projectStage.equals("PRODUCCION")){
			destinatarioEmail = destinatario;
			copiaOcultaDestinatarioEmail = "gsolano@ups.edu.ec";
		}

		try {
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
			helper.setTo(destinatarioEmail);
			helper.setBcc(copiaOcultaDestinatarioEmail);
			helper.setFrom("notificaciones@ups.edu.ec");
			helper.setSubject(asuntoEmail);

			// Establecer el contenido HTML del mensaje
			helper.setText(htmlContent, true);
			// Enviar el correo electrónico
			mailSender.send(message);
		} catch (MessagingException e) {
			throw new RuntimeException(e + "Error en el envío de email"+ destinatario);
		}
	}

	public String prepararFormatoHtml(String nombreDestinatario, String messageContent2, String messageContent3, String messageContent4, String htmlContent3, String htmlContent4){
		String htmlContent =
				"<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"background-color: #f2f2f2;width:100%;\">" +
						"<tbody>" +
						"<tr>" +
							"<td style=\"padding: 20px 20px 5px 20px;\">" +
							"<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"width:100%;border:1px solid #DDD;border-radius: 5px;box-shadow: 0px 0px 3px 0px #CCC;border-collapse:separate;background-color: #FFF;\">" +
							"<tbody>" +
							"<tr>" +
							"<td style=\"text-align:left;font-size:20px;color:#FFFFFF;background-color:#0973b5;border-radius: 0px 0px 4px 4px;\">" +
							"<div style=\"height:5px;\" />" +
							"</td>" +
						"</tr>" +
						"<tr>" +
							"<td>" +
							"<div style=\"padding:10px;text-align:center;font-weight: 600;color:#2E74B5;\">" + title1 +
							"<br> <div style=\"text-align:center;font-weight: 600;color:#2E74B5;\">" + title2 +
							"</div></div>"  +
							"</td>" +
						"</tr>" +
						"<tr>" +
							"<td style=\"padding:10px;\">" + messageContent1 + "<b>" + nombreDestinatario + "</b>" +
							"</br></br>" +
							"<p>" + messageContent2 + messageContent3 + "</p>" +
							"</td>" +
						"</tr>" +
						"<tr>" +
							"<td style=\"padding:10px;\">" + htmlContent3 + // Utiliza para mostrar tablas
							"</td>" +
						"</tr>" + messageContent4 +
						"<tr>" +
							"<td style=\"padding:10px;\">" + htmlContent4 + // Utiliza para mostrar tablas
							"</td>" +
						"</tr>" +
						"</tbody>" +
						"</table>" +

						"</td>" +
						"</tr>" +
						"<tr>" +
							"<td style=\"text-align:center;font-size:10px;color: #555;\">" +
							"</td>" +
						"</tr>" +
						"</tbody>" +
						"</table>";
		return htmlContent;
	}

	//* ANEXO 6
	//* ENVIAR NOTIFICACION AL TRABAJADOR SOCIAL CUANDO COMPLETA LA FICHA SOCIOECONÓMICA
	@Override
	@Transactional(readOnly = true)
	public ResponseEntity<?> enviarCorreoTrabajadorSocial(String cedula, Long codigoSolicitud) {
		String messageContent3 = " con número de identificación No. <b>"+ cedula + "</b>, ha registrado y completado la información " +
				"solicitada en la Ficha Socioeconómica Ampliada, por favor proceder con la revisión del caso. " +
				"<br><br> Detalle de información:";
		String mesaggeAtt = "Atentamente,";
		String contentAtt = "Secretaría Técnica de Bienestar Universitario";

		try {
			datosSolicitudEstudiante(cedula, codigoSolicitud);
			String messageContent2 = "Se notifica que el/la estudiante " + "<b>" + nombreEstudiante + "</b>";
			if( numeroSolicitud != null){
				String nombreDestinatario = nombreTrabajadorSocial;
				String emailDestinatario = correoTrabajadorSocial;

				// Construir el contenido HTML
				String htmlContent3 =
						"<table border=\"1\">"+
								"<tr>"+
								"<td><b>" + "Nro. trámite solicitud" + "</b></td>" +
								"<td><b>" + "Tipo solicitud" + "</b></td>" +
								"<td><b>" + "% Porcentaje de registro de información de la Ficha Socioeconómica Ampliada" + "</b></td>" +
								"<td><b>" + "Fecha de registro de finalización de Ficha Socioeconómica Ampliada" + "</b></td>" +
								"</tr>"+
								"<tr>"+
								"<td style=\"text-align:center;\">" + numeroSolicitud + "</td>" +
								"<td style=\"text-align:center;\">" + descripcionTipoSolicitud + "</td>" +
								"<td style=\"text-align:center;\">" + "100%" + "</td>" +
								"<td style=\"text-align:center;\">" + fechaFinalizacionFicha + "</td>" +
								"</tr>"+
								"</table>";

				String htmlContent4=  "</br>" + mesaggeAtt + "<br>" + contentAtt +
						"</td>" +
						"</tr>" +
						"<tr>" +
						"<td style=\"text-align:left;font-size:20px;color:#FFFFFF;background-color:#f2c351;border-radius: 0px 0px 4px 4px;\">" +
						"<div style=\"height:5px;\" />" +
						"</td>" +
						"</tr>" +
						"</tbody>" +
						"</table>" +
						"</td>" +
						"</tr>" +
						"<tr>" +
						"<td style=\"text-align:center;font-size:10px;color: #555;\">" +
						"</td>" +
						"</tr>" +
						"</tbody>" +
						"</table>" ;

				String htmlContent = prepararFormatoHtml(nombreDestinatario,
						messageContent2, messageContent3, "", htmlContent3, htmlContent4);
				sendEmailUsuario(emailDestinatario, htmlContent);
				return new ResponseEntity<>("Email enviado", HttpStatus.OK);
			}
		}catch (Exception e){
			return new ResponseEntity<>("No se pudo enviar el email", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>("Email no enviado", HttpStatus.OK);
	}

	//* ANEXO 7
	//* ENVIAR NOTIFICACIÓN AL ESTUDIANTE CUANDO COMPLETA LA FICHA SOCIOECONÓMICA
	@Override
	@Transactional(readOnly = true)
	public ResponseEntity<?> enviarCorreo(String cedula, Long codigoSolicitud) {
		String mesaggeAtt = "Atentamente,";
		String contentAtt = "Secretaría Técnica de Bienestar Universitario";

		try {
			datosSolicitudEstudiante(cedula, codigoSolicitud);
			String nombreDestinatario = nombreEstudiante;
			String emailDestinatario = emailEstudiante;

			String messageContent3 = "Conforme su trámite de solicitud <b> # " + numeroSolicitud + " ''"+ descripcionTipoSolicitud +
					"''</b>, se notifica que la Ficha Socioeconómica Ampliada fue completada satisfactoriamente.";
			if( numeroSolicitud != null ){
				// Construir el contenido HTML
				String htmlContent3 =
						"</br>" + mesaggeAtt + "<br>" + contentAtt +
								"</td>" +
								"</tr>" +
								"<tr>" +
								"<td style=\"text-align:left;font-size:20px;color:#FFFFFF;background-color:#f2c351;border-radius: 0px 0px 4px 4px;\">" +
								"<div style=\"height:5px;\" />" +
								"</td>" +
								"</tr>" +
								"</tbody>" +
								"</table>" +
								"</td>" +
								"</tr>" +
								"<tr>" +
								"<td style=\"text-align:center;font-size:10px;color: #555;\">" +
								"</td>" +
								"</tr>" +
								"</tbody>" +
								"</table>";

				String htmlContent = prepararFormatoHtml(nombreDestinatario,
						"", messageContent3, "", htmlContent3, "");
				sendEmailUsuario(emailDestinatario, htmlContent);
				return new ResponseEntity<>("Email enviado", HttpStatus.OK);
			}
		}catch (Exception e){
			return new ResponseEntity<>("No se pudo enviar el email", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>("Email no enviado", HttpStatus.OK);
	}

	//* ANEXO 8
	//* NOTIFICACION DOCUMENTOS ADICIONALES PENDIENTES AL ESTUDIANTE
	@Override
	@Transactional(readOnly = true)
	public ResponseEntity<?> notificarAnexo8(String cedula, Long codigoSolicitud) {
		Long codigoFicha = documentosSolicitadosDao.obtenerCodigoFichaAmpliada(cedula);
		List<SbeDocumentoSolicitadoFicha> documentosSolicitados = documentosSolicitadosDao.obtenerDocumentosSolicitados(codigoFicha);

		String enlace = "http://localhost:3000/subirInformacionAdicional/"+cedula;
		String messageContent3 = ", se notifica que debe enviar la siguiente documentación como complemento adicional a la información registrada en la Ficha Socioeconómica Ampliada: ";
		String messageContent4 = "La documentación debe ser cargada digitalmente al sistema de la Universidad Politécnica Salesiana en formato pdf. ";
		String messageContent5 = "Para acceder al sistema debe <b> iniciar sesión </b> con sus credenciales <b>(usuario y contraseña)</b> a <b>través del portal web </b> institucional www.ups.edu.ec, en la opción Ficha Socioeconómica Ampliada. O puede acceder directamente al siguiente enlace: ";
		String mesaggeAtt = "Atentamente,";
		String contentAtt = "Secretaría Técnica de Bienestar Universitario";
		String asuntoEmail = "Documentos adicionales pendientes";

		try {
			datosSolicitudEstudiante(cedula, codigoSolicitud);
			String nombreDestinatario = nombreEstudiante;
			String emailDestinatario = emailEstudiante;
			String messageContent2 = "Conforme su trámite de solicitud <b> # " + numeroSolicitud + "&ensp; ''" + descripcionTipoSolicitud + "'' </b>";
			if( numeroSolicitud != null ){
				// Construir el contenido HTML
				messageContent4 =
						"<tr>"+
								"<td style=\"padding:10px;\">" +
								"</br><b>" + messageContent4 + "</b>" + messageContent5 +
								"<a href=" + enlace+">"+"&nbsp"+enlace+"</a>"+
								"</td>" +
								"</tr>" ;
				String htmlContent3 = "" +
						"<table border=\"1\" style=\"border-collapse: collapse; width: 100%;\">" +
						"<tr>" +
						"<th style=\"width: 25%; text-align: center;\"><b>Nro</b></th>" +
						"<th style=\"width: 25%; text-align: center;\"><b>Documentos solicitados</b></th>" +
						"<th style=\"width: 25%; text-align: center;\"><b>Fecha límite para envío de documentación</b></th>" +
						"<th style=\"width: 25%; text-align: center;\"><b>Estado</b></th>" +
						"</tr>";
				for (int i = 0; i < documentosSolicitados.size(); i++) {
					String estadoDoc = documentosSolicitados.get(i).getDocEstadoDocumento();
					estadoDoc = Objects.equals(estadoDoc, "S") ? "Subido" : "Pendiente";

					htmlContent3 += "" +
							"<tr>" +
							"<td style=\"width: 25%; text-align: center;\">" + i + "</td>" +
							"<td style=\"width: 25%; text-align: center;\">" + documentosSolicitados.get(i).getDocDescripcion() + "</td>" +
							"<td style=\"width: 25%; text-align: center;\">" + documentosSolicitados.get(i).getDocFechaLimiteEnvio() + "</td>" +
							"<td style=\"width: 25%; text-align: center;\">" + estadoDoc + "</td>" +
							"</tr>";
				}
				htmlContent3 += "</table>";

				String htmlContent4=  "</br>" + mesaggeAtt + "<br>" + contentAtt +
						"</td>" +
						"</tr>" +
						"<tr>" +
						"<td style=\"text-align:left;font-size:20px;color:#FFFFFF;background-color:#f2c351;border-radius: 0px 0px 4px 4px;\">" +
						"<div style=\"height:5px;\" />" +
						"</td>" +
						"</tr>" +
						"</tbody>" +
						"</table>" +
						"</td>" +
						"</tr>" +
						"<tr>" +
						"<td style=\"text-align:center;font-size:10px;color: #555;\">" +
						"</td>" +
						"</tr>" +
						"</tbody>" +
						"</table>" ;

				String htmlContent = prepararFormatoHtml(nombreDestinatario,
						messageContent2, messageContent3, messageContent4, htmlContent3, htmlContent4);
				sendEmailUsuario(emailDestinatario, htmlContent);
				return new ResponseEntity<>("Email enviado", HttpStatus.OK);
			}
		} catch (Exception e){
			return new ResponseEntity<>("No se pudo enviar el email", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>("Email no enviado", HttpStatus.OK);
	}

	//* ANEXO 11
	// ENVIAR NOTIFICACION DE CORREO ELECTRONICO AL ESTUDIANTE INDICANDO QUE SE HAN SUBIDO TODOS LOS DOCUMENTOS
	@Override
	@Transactional(readOnly = true)
	public ResponseEntity<?> notificarDocumentosSubidos(String cedula, Long codigoSolicitud) {
		Long codigoFicha = documentosSolicitadosDao.obtenerCodigoFichaAmpliada(cedula);
		List<SbeDocumentoSolicitadoFicha> documentosSolicitados = documentosSolicitadosDao.obtenerDocumentosSolicitados(codigoFicha);

		String messageContent3 = ", se notifica que la documentación como complemento adicional a la información registrada en la Ficha Socioeconómica Ampliada, ha sido subida en su totalidad:";
		String messageContent4 = "Se procederá con la revisión respectiva.";
		String mesaggeAtt = "Atentamente,";
		String contentAtt = "Secretaría Técnica de Bienestar Universitario";

		try {
			datosSolicitudEstudiante(cedula, codigoSolicitud);
			String nombreDestinatario = nombreEstudiante;
			String emailDestinatario = emailEstudiante;
			String messageContent2 = "Conforme su trámite de solicitud <b># " + numeroSolicitud + "&ensp; ''" + descripcionTipoSolicitud + "''</b>" ;

			if( numeroSolicitud != null ){
				// Construir el contenido HTML
				messageContent4 =
						"<tr>"+
								"<td style=\"padding:10px;\">" +
								"</br><b>" + messageContent4 + "</b>" +
								"</td>" +
								"</tr>" ;

				String htmlContent3 = "<table border=\"1\" style=\"border-collapse: collapse; width: 100%;\">" +
						"<tr>" +
						"<th style=\"width: 25%; text-align: center;\"><b>Nro</b></th>" +
						"<th style=\"width: 25%; text-align: center;\"><b>Documentos solicitados</b></th>" +
						"<th style=\"width: 25%; text-align: center;\"><b>Estado</b></th>" +
						"</tr>";
				for (int i = 0; i < documentosSolicitados.size(); i++) {
					htmlContent3 += "" +
							"<tr>" +
							"<td style=\"width: 25%; text-align: center;\">" + i + "</td>" +
							"<td style=\"width: 25%; text-align: center;\">" + documentosSolicitados.get(i).getDocDescripcion() + "</td>" +
							"<td style=\"width: 25%; text-align: center;\">" + documentosSolicitados.get(i).getDocEstadoDocumento().replace("S","SUBIDO")  + "</td>" +
							"</tr>";
				}
				htmlContent3 += "</table>";

				String htmlContent4=  "</br>" + mesaggeAtt + "<br>" + contentAtt +
						"</td>" +
						"</tr>" +
						"<tr>" +
						"<td style=\"text-align:left;font-size:20px;color:#FFFFFF;background-color:#f2c351;border-radius: 0px 0px 4px 4px;\">" +
						"<div style=\"height:5px;\" />" +
						"</td>" +
						"</tr>" +
						"</tbody>" +
						"</table>" +
						"</td>" +
						"</tr>" +
						"<tr>" +
						"<td style=\"text-align:center;font-size:10px;color: #555;\">" +
						"</td>" +
						"</tr>" +
						"</tbody>" +
						"</table>" ;

				String htmlContent = prepararFormatoHtml(nombreDestinatario,
						messageContent2, messageContent3, messageContent4, htmlContent3, htmlContent4);
				sendEmailUsuario(emailDestinatario, htmlContent);
				return new ResponseEntity<>("Email enviado", HttpStatus.OK);
			}
		}catch (Exception e){
			return new ResponseEntity<>("No se pudo enviar el email", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>("Email no enviado", HttpStatus.OK);
	}

	//* ANEXO 14
	//NOTIFICACIÓN DE INFORME DE CASOS DE REVISIÓN NIVEL DE BECA / QUINTIL
	@Override
	@Transactional(readOnly = true)
	public ResponseEntity<?> notificarAnexo14(String cedula, Long codigoSolicitud) {
		String messageContent2 = "Se notifica que se encuentra disponible para su revisión el informe de casos del estudiante correspondiente a la Ficha Socioeconómica Ampliada; \n" ;
		String mesaggeAtt = "Atentamente,";
		String contentAtt = "Trabajador/a Social asignado\n";

		try {
			datosSolicitudEstudiante(cedula, codigoSolicitud);
			String nombreDestinatario = nombreDirectorTecnico;
			String emailDestinatario = correoDirectorTecnico;
			if( numeroSolicitud != null){
				// Construir el contenido HTML
				String htmlContent3 =
						"<table border=\"1\" style=\"border-collapse: collapse; width: 100%;\">" +
								"<tr>" +
								"<th style=\"width: 25%; text-align: center;\"><b>Nombre</b></th>" +
								"<th style=\"width: 25%; text-align: center;\"><b>Nro. De Identificación</b></th>" +
								"<th style=\"width: 25%; text-align: center;\"><b>Número de solicitud</b></th>" +
								"<th style=\"width: 25%; text-align: center;\"><b>Tipo de solicitud</b></th>" +
								"</tr>" +
								"<tr>" +
								"<td style=\"width: 25%; text-align: center;\">" + nombreEstudiante + "</td>" +
								"<td style=\"width: 25%; text-align: center;\">" + cedula + "</td>" +
								"<td style=\"width: 25%; text-align: center;\">" + numeroSolicitud + "</td>" +
								"<td style=\"width: 25%; text-align: center;\">" + descripcionTipoSolicitud + "</td>" +
								"</tr>"+
								"</table>";

				String htmlContent4=  "</br>" + mesaggeAtt + "<br>" + contentAtt +
						"</td>" +
						"</tr>" +
						"<tr>" +
						"<td style=\"text-align:left;font-size:20px;color:#FFFFFF;background-color:#f2c351;border-radius: 0px 0px 4px 4px;\">" +
						"<div style=\"height:5px;\" />" +
						"</td>" +
						"</tr>" +
						"</tbody>" +
						"</table>" +
						"</td>" +
						"</tr>" +
						"<tr>" +
						"<td style=\"text-align:center;font-size:10px;color: #555;\">" +
						"</td>" +
						"</tr>" +
						"</tbody>" +
						"</table>" ;

				String htmlContent = prepararFormatoHtml(nombreDestinatario,
						messageContent2, "", "", htmlContent3, htmlContent4);
				sendEmailUsuario(emailDestinatario, htmlContent);
				return new ResponseEntity<>("Email enviado", HttpStatus.OK);
			}
		} catch (Exception e){
			return new ResponseEntity<>("No se pudo enviar email", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>("Email no enviado", HttpStatus.OK);
	}

	//* ANEXO 16 : se envía al Estudiante
	//NOTIFICACIÓN DE APROBACIÓN / NO APROBACIÓN DE REVISIÓN
	//DE NIVEL DE BECA/ QUINTIL POR PENSIÓN DIFERENCIADA
	@Override
	@Transactional(readOnly = true)
	public ResponseEntity<?> notificarAnexo16Recalculo(String cedula, Long codigoSolicitud) {
		String mesaggeAtt = "Atentamente,";
		String contentAtt = "Secretaría Técnica de Bienestar Universitario.\n";

		try {
			datosSolicitudEstudiante(cedula, codigoSolicitud);
			String nombreDestinatario = nombreEstudiante;
			String emailDestinatario = emailEstudiante;

			String messageContent3 = "En respuesta a su solicitud de Revisión de nivel de beca/ quintil, trámite de solicitud <b>" +
					"# " + numeroSolicitud + " ''" + descripcionTipoSolicitud + "''</b>, se informa: " +
					"<br><br>Su solicitud ha sido TRAMITADA. Favor revisar detalles a través del sistema de solicitudes en línea. " +
					"<br><br>A partir del siguiente periodo académico se verá reflejado su nuevo nivel de beca/quintil. " +
					"<br><br><b>Nivel de beca/quintil asignado: " + nivelBeca +
					"<br>Aplicación a partir del período académico: " + periodoAplicaFicha + "</b>";

			if( numeroSolicitud != null){
				// Construir el contenido HTML
				String htmlContent4=  "</br>" + mesaggeAtt + "<br>" + contentAtt +
						"</td>" +
						"</tr>" +
						"<tr>" +
						"<td style=\"text-align:left;font-size:20px;color:#FFFFFF;background-color:#f2c351;border-radius: 0px 0px 4px 4px;\">" +
						"<div style=\"height:5px;\" />" +
						"</td>" +
						"</tr>" +
						"</tbody>" +
						"</table>" +
						"</td>" +
						"</tr>" +
						"<tr>" +
						"<td style=\"text-align:center;font-size:10px;color: #555;\">" +
						"</td>" +
						"</tr>" +
						"</tbody>" +
						"</table>" ;

				String htmlContent = prepararFormatoHtml(nombreDestinatario,
						"", messageContent3, "", "", htmlContent4);
				sendEmailUsuario(emailDestinatario, htmlContent);
				return new ResponseEntity<>("Email enviado", HttpStatus.OK);
			}
		} catch (Exception e){
			return new ResponseEntity<>("No se pudo enviar email", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>("Email no enviado", HttpStatus.OK);
	}

	//* ANEXO 16 : se envía al  Estudiante
	//NOTIFICACIÓN DE APROBACIÓN / NO APROBACIÓN DE REVISIÓN
	//DE NIVEL DE BECA/ QUINTIL POR PENSIÓN DIFERENCIADA
	@Override
	@Transactional(readOnly = true)
	public ResponseEntity<?> notificarAnexo16NoRecalculo(String cedula, Long codigoSolicitud) {
		String mesaggeAtt = "Atentamente,";
		String contentAtt = "Secretaría Técnica de Bienestar Universitario.\n";

		try {
			datosSolicitudEstudiante(cedula, codigoSolicitud);
			String nombreDestinatario = nombreEstudiante;
			String emailDestinatario = emailEstudiante;

			String messageContent3 = "En respuesta a su solicitud de Revisión de nivel de beca/quintil N°. <b>"+
					numeroSolicitud + "</b> con fecha <b>" + solicitudFecha + "</b> se informa: " +
					"<br><br>Su solicitud ha sido TRAMITADA. Favor revisar detalles a través del sistema de solicitudes en línea. " +
					"<br><br><b> Observaciones: </b>" + observacionSolicitud;

			if( numeroSolicitud != null){
				// Construir el contenido HTML
				String htmlContent4=  "</br>" + mesaggeAtt + "<br>" + contentAtt +
						"</td>" +
						"</tr>" +
						"<tr>" +
						"<td style=\"text-align:left;font-size:20px;color:#FFFFFF;background-color:#f2c351;border-radius: 0px 0px 4px 4px;\">" +
						"<div style=\"height:5px;\" />" +
						"</td>" +
						"</tr>" +
						"</tbody>" +
						"</table>" +
						"</td>" +
						"</tr>" +
						"<tr>" +
						"<td style=\"text-align:center;font-size:10px;color: #555;\">" +
						"</td>" +
						"</tr>" +
						"</tbody>" +
						"</table>" ;

				String htmlContent = prepararFormatoHtml(nombreDestinatario,
						messageContent3, "", "", "", htmlContent4);
				sendEmailUsuario(emailDestinatario, htmlContent);
				return new ResponseEntity<>("Email enviado", HttpStatus.OK);
			}
		} catch (Exception e){
			return new ResponseEntity<>("No se pudo enviar email", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>("Email no enviado", HttpStatus.OK);
	}

	//* ANEXO 17 : se envía al  Trabajador Social
	//NOTIFICACIÓN DE APROBACIÓN / NO APROBACIÓN DE REVISIÓN
	//DE NIVEL DE BECA/ QUINTIL POR PENSIÓN DIFERENCIADA
	@Override
	@Transactional(readOnly = true)
	public ResponseEntity<?> notificarAnexo17Recalculo(String cedula, Long codigoSolicitud) {
		String mesaggeAtt = "Atentamente,";
		String contentAtt = "<b>"+nombreDirectorTecnico+"</b>";

		try {
			datosSolicitudEstudiante(cedula, codigoSolicitud);
			String nombreDestinatario = nombreTrabajadorSocial;
			String emailDestinatario = correoTrabajadorSocial;

			String messageContent2 = "De acuerdo con el informe presentado se notifica que se encuentra <b>activada</b> " +
					"la valoración de nivel de beca/quintil para el estudiante; ";
			String messageContent4 = "A partir del siguiente periodo académico se verá reflejado el nuevo nivel de beca/ quintil." +
					"<br><br><b> Nivel de beca/ quintil asignado: " + nivelBeca +
					"<br>Aplicación a partir del período académico: " + periodoAplicaFicha + "</b>";

			if( numeroSolicitud != null){
				// Construir el contenido HTML
				messageContent4 =
						"<tr>"+
								"<td style=\"padding:10px;\">" +
								"</br>" + messageContent4 +
								"</td>" +
								"</tr>" ;

				String htmlContent3 =
						"<table border=\"1\" style=\"border-collapse: collapse; width: 100%;\">" +
								"<tr>" +
								"<th style=\"width: 25%; text-align: center;\"><b>Nombre del estudiante</b></th>" +
								"<th style=\"width: 25%; text-align: center;\"><b>Número de identificación</b></th>" +
								"<th style=\"width: 25%; text-align: center;\"><b>Nro. Trámite de Solicitud</b></th>" +
								"<th style=\"width: 25%; text-align: center;\"><b>Tipo de solicitud</b></th>" +
								"</tr>" +
								"<tr>" +
								"<td style=\"width: 25%; text-align: center;\">" + nombreEstudiante + "</td>" +
								"<td style=\"width: 25%; text-align: center;\">" + cedula + "</td>" +
								"<td style=\"width: 25%; text-align: center;\">" + numeroSolicitud + "</td>" +
								"<td style=\"width: 25%; text-align: center;\">" + descripcionTipoSolicitud+ "</td>" +
								"</tr>"+
								"</table>";

				String htmlContent4=  "</br>" + mesaggeAtt + "<br>" + contentAtt +
						"</td>" +
						"</tr>" +
						"<tr>" +
						"<td style=\"text-align:left;font-size:20px;color:#FFFFFF;background-color:#f2c351;border-radius: 0px 0px 4px 4px;\">" +
						"<div style=\"height:5px;\" />" +
						"</td>" +
						"</tr>" +
						"</tbody>" +
						"</table>" +
						"</td>" +
						"</tr>" +
						"<tr>" +
						"<td style=\"text-align:center;font-size:10px;color: #555;\">" +
						"</td>" +
						"</tr>" +
						"</tbody>" +
						"</table>" ;

				String htmlContent = prepararFormatoHtml(nombreDestinatario,
						messageContent2, "", messageContent4, htmlContent3, htmlContent4);
				sendEmailUsuario(emailDestinatario, htmlContent);
				return new ResponseEntity<>("Email enviado", HttpStatus.OK);
			}
		} catch (Exception e){
			return new ResponseEntity<>("No se pudo enviar email", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>("Email no enviado", HttpStatus.OK);
	}

	//* ANEXO 17 : se envía al  Trabajador Social
	//NOTIFICACIÓN DE APROBACIÓN / NO APROBACIÓN DE REVISIÓN
	//DE NIVEL DE BECA/ QUINTIL POR PENSIÓN DIFERENCIADA
	@Override
	@Transactional(readOnly = true)
	public ResponseEntity<?> notificarAnexo17NoRecalculo(String cedula, Long codigoSolicitud) {
		String mesaggeAtt = "Atentamente,";
		String contentAtt = "<b>"+nombreDirectorTecnico+"</b>";

		try {
			datosSolicitudEstudiante(cedula, codigoSolicitud);
			String nombreDestinatario = nombreTrabajadorSocial;
			String emailDestinatario = correoTrabajadorSocial;

			String messageContent3 = "De acuerdo con el informe presentado se notifica que no procede la activación de valoración " +
					"del nivel de beca/quintil de la <b>Ficha Socioeconómica Ampliada</b>, para el estudiante <b>"+ nombreEstudiante + "</b>"+
					" con Número de Identificación No. <b>" + cedula + "</b>, por la siguiente razón"+
					"<br><br>Observaciones: " + observacionSolicitud;

			if( numeroSolicitud != null){
				// Construir el contenido HTML
				String htmlContent4=  "</br>" + mesaggeAtt + "<br>" + contentAtt +
						"</td>" +
						"</tr>" +
						"<tr>" +
						"<td style=\"text-align:left;font-size:20px;color:#FFFFFF;background-color:#f2c351;border-radius: 0px 0px 4px 4px;\">" +
						"<div style=\"height:5px;\" />" +
						"</td>" +
						"</tr>" +
						"</tbody>" +
						"</table>" +
						"</td>" +
						"</tr>" +
						"<tr>" +
						"<td style=\"text-align:center;font-size:10px;color: #555;\">" +
						"</td>" +
						"</tr>" +
						"</tbody>" +
						"</table>" ;

				String htmlContent = prepararFormatoHtml(nombreDestinatario,
						messageContent3, "", "", "", htmlContent4);
				sendEmailUsuario(emailDestinatario, htmlContent);
				return new ResponseEntity<>("Email enviado", HttpStatus.OK);
			}
		} catch (Exception e){
			return new ResponseEntity<>("No se pudo enviar email", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>("Email no enviado", HttpStatus.OK);
	}

}
