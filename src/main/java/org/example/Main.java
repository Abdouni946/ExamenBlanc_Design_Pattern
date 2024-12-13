package org.example;

import org.example.agentManager.Agent;
import org.example.agentManager.Container;

public class Main {
    public static void main(String[] args) {
        Container container = Container.getInstance();

        Agent agent1 = new Agent("AgentA");
        Agent agent2 = new Agent("AgentB");
        Agent agent3 = new Agent("AgentC");

        container.addAgent(agent1);
        container.addAgent(agent2);
        container.addAgent(agent3);

        container.displayAllAgents();

        Agent retrievedAgent = container.getAgent("AgentB");
        System.out.println("Agent récupéré : " + retrievedAgent.getName());

        container.removeAgent("AgentA");

        container.displayAllAgents();

        System.out.println("Nombre total d'agents : " + container.getAgentCount());
    }
}
