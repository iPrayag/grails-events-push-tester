import grails.events.Listener

class MyService {
	//will receive client events from 'serverExportService' topic
	@Listener(namespace='browser') 
	def serverExportService(Map data){
		log.info(data)
		data.reporting = "firstName : Prayag, lastName : Upd"
		event('clientExportListener', data, {}) // will trigger registered browsers on 'clientExportListener' topic
	}
}
