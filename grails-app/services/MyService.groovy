import grails.events.Listener

class MyService {
	//will receive client events from 'serverExportService' topic
	@Listener(namespace='browser') 
	def serverExportService(Map data){
	    log.info(data)
            10.times {  
		data.reporting = " ${it} : {firstName : Prayag, lastName : Upd}"
		event('clientExportListener', data, {}) // will trigger registered browsers on 'clientExportListener' topic
                Thread.sleep(2000) //wait for 2 sec
            }
	}
}
