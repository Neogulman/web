
package com.neogul.websocket.policy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Collection;
import java.util.Collections;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.ServletContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.neogul.common.JavaCipher;
import com.neogul.common.StringUtil;

/**
 * Sets up the timer for the multi agent WebSocket.
 */
public class AgentHandler {

	 
    private static final Log log = LogFactory.getLog(AgentHandler.class);

    private static Timer heartTimer = null;

    private static final long TICK_DELAY = 1000*60; //ms(1분)

    private static final ConcurrentHashMap<Integer, Agent> agents =
            new ConcurrentHashMap<Integer, Agent>();
    
    private static String license;

    public static synchronized void addAgent(Agent agent) {
        if (agents.size() == 0) {
        	agent.updateDeviceStatusAll();
            startTimer();
        }
        agents.put(Integer.valueOf(agent.getId()), agent);
        log.info("agents count :"+String.valueOf(agents.size()));
        
    }

    public static synchronized void chkLicense(Agent agent, ServletContext context) {
		
        String path = context.getRealPath("/");
		path = StringUtil.fnReplace(path);
		BufferedReader in;
		try {
			in = new BufferedReader(new FileReader(new File(path+"WEB-INF/LICENSE")));
			String tmp = "";
			while((tmp = in.readLine()) != null){
				license = JavaCipher.Decrypt(tmp);
				break;
			}
			in.close();
			in = null;
		} catch ( Exception e) {
			license = "0"; 
			e.printStackTrace();
		}
			
		log.info("license is :" + license);
        if (agents.size() > Integer.parseInt(license)){
        	agent.kill(SND_MSG.NOT_LIC);
        }
	}

    public static Collection<Agent> getAgents() {
        return Collections.unmodifiableCollection(agents.values());
    }


    public static synchronized void removeAgent(Agent agent) {
        agents.remove(Integer.valueOf(agent.getId()));
        if (agents.size() == 0) {
            stopTimer();
        }
        log.info("agents count :"+String.valueOf(agents.size()));
    }


    public static void tick() throws Exception {
        broadcast(0);
    }

    public static void broadcast(int type) throws Exception {
        for (Agent agent : AgentHandler.getAgents()) {
            agent.sendMessage(SND_MSG.ECHO);
        }
    }


    public static void startTimer() {
        heartTimer = new Timer(AgentHandler.class.getSimpleName() + " Timer");
        heartTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                try {
                    tick();
                } catch (Throwable e) {
                    log.error("Caught to prevent timer from shutting down", e);
                }
            }
        }, TICK_DELAY, TICK_DELAY);
    }


    public static void stopTimer() {
        if (heartTimer != null) {
            heartTimer.cancel();
        }
    }

	public static void kill(String agent_id) {
		for (Agent agent : AgentHandler.getAgents()) {
			if(agent.getAgent_id().equals(agent_id)){
				agent.kill(SND_MSG.BLOCKING);
			}
        }
	}

	public static void updatePolicy(String agent_id) {
		for (Agent agent : AgentHandler.getAgents()) {
			if(agent.getAgent_id().equals(agent_id)){
				agent.sendPolicy();
			}
        }
	}

	public static void updateOutPolicy(String agent_id) {
		for (Agent agent : AgentHandler.getAgents()) {
			if(agent.getAgent_id().equals(agent_id)){
				agent.sendOutPolicy();
			}
        }
		
	}
}
