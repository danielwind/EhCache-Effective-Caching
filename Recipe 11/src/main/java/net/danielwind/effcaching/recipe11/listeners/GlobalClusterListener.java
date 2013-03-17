package net.danielwind.effcaching.recipe11.listeners;

import org.apache.log4j.Logger;

import net.sf.ehcache.cluster.ClusterNode;
import net.sf.ehcache.cluster.ClusterTopologyListener;

/**
 * Terracotta Cluster Global Events Listener 
 * @author daniel.wind.m@gmail.com
 *
 */
public class GlobalClusterListener implements ClusterTopologyListener {

	private static final Logger log = Logger.getLogger(GlobalClusterListener.class);
	
	@Override
	public void nodeJoined(ClusterNode node) {
		log.info("--- Node ID: " + node.getId() + " has joined the cluster! ---");
	}

	@Override
	public void nodeLeft(ClusterNode node) {
		log.info("--- Node ID: " + node.getId() + " has left the cluster! ---");	
	}

	@Override
	public void clusterOnline(ClusterNode node) {
		log.info("--- Node ID:" + node.getId() + " is active and eager for clustering operations... ---");
	}

	@Override
	public void clusterOffline(ClusterNode node) {
		log.info("-- Node ID: " + node.getId() + " has lost connection to the cluster! ---");
	}

	@Override
	public void clusterRejoined(ClusterNode oldNode, ClusterNode newNode) {
		log.info("--- Node ID: " + oldNode.getId() + " has rejoined the cluster as Node ID: " + newNode.getId() + " ---");
	}

}