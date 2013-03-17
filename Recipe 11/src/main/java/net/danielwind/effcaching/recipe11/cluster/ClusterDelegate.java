package net.danielwind.effcaching.recipe11.cluster;

import java.util.Collection;

import net.danielwind.effcaching.recipe11.listeners.GlobalClusterListener;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.cluster.CacheCluster;
import net.sf.ehcache.cluster.ClusterNode;
import net.sf.ehcache.cluster.ClusterScheme;

import org.apache.log4j.Logger;

public final class ClusterDelegate {
	
	private static final Logger log = Logger.getLogger(ClusterDelegate.class);
	
	private CacheCluster cluster;
	private GlobalClusterListener clusterListener;
	
	/**
	 * Constructor. Initializes the Cache Cluster reference according to 
	 * the cache manager being passed. 
	 * @param cacheManager
	 */
	public ClusterDelegate() {
		
		//create and initialize cluster
		cluster = new CacheManager().getCluster(ClusterScheme.TERRACOTTA);
		
		//add event listener 
		clusterListener = new GlobalClusterListener();
		cluster.addTopologyListener(clusterListener);
		
		printClusterNodesInformation();
		
		log.info("-------------------------------");
		log.info("Cluster is online: " + cluster.isClusterOnline());
		log.info("-------------------------------");
	}
	
	/**
	 * Logs information about all the cluster nodes currently detected
	 */
	private void printClusterNodesInformation() {
		
		Collection<ClusterNode> nodes = cluster.getNodes();
		
		for(ClusterNode node:nodes){
			log.info("Node found: {ID: " + node.getId() + ", Host Name: "+ node.getHostname() +", IP: " + node.getIp() + "}");
		}
	} 
	
	public static void main(String[] args) {
		ClusterDelegate _cluster = new ClusterDelegate();
		log.info("Cluster Scheme: " + _cluster.cluster.getScheme() + " has been loaded...");
	}

}
