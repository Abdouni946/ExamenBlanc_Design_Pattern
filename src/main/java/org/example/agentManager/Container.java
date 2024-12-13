package org.example.agentManager;

import java.util.HashMap;
import java.util.Map;

public class Container {
    private static Container instance;
    private final Map<String, Agent> agents;

    private Container() {
        this.agents = new HashMap<>();
    }

    public static synchronized Container getInstance() {
        if (instance == null) {
            instance = new Container();
        }
        return instance;
    }

    public void addAgent(Agent agent) {
        if (agent != null && !agents.containsKey(agent.getName())) {
            agents.put(agent.getName(), agent);
            System.out.println("Agent ajouté : " + agent.getName());
        } else {
            System.out.println("L'agent existe déjà ou est invalide.");
        }
    }

    public void removeAgent(String name) {
        if (agents.containsKey(name)) {
            agents.remove(name);
            System.out.println("Agent supprimé : " + name);
        } else {
            System.out.println("L'agent n'existe pas.");
        }
    }

    public Agent getAgent(String name) {
        return agents.get(name);
    }

    public void displayAllAgents() {
        System.out.println("Liste des agents :");
        for (Agent agent : agents.values()) {
            System.out.println(agent);
        }
    }

    public int getAgentCount() {
        return agents.size();
    }
}