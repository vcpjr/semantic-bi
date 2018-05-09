package pojo;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * Represents a Knowledge Graph Node (i.g., a class or resource on DBpedia)
 * @author vilmar
 *
 */
public class KGNode {

	@Override
	public String toString() {
		return "KGNode [label=" + label + ", uri=" + uri + ", directHits=" + directHits + ", indirectHits="
				+ indirectHits + ", relationships=" + relationships + "]";
	}

	private String label;
	private String uri;
	private int directHits;
	private int indirectHits;
	private Map<KGNode, String> relationships;

	public KGNode() {

	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public Map<KGNode, String> getRelationships() {
		return relationships;
	}

	public void setRelationships(Map<KGNode, String> relationships) {
		this.relationships = relationships;
	}

	public void addRelationship(String type, KGNode otherNode){
		if(!this.relationships.containsKey(otherNode)){
			relationships.put(otherNode, type);
		}
	}

	public KGNode(String uri) {
		super();

		//TODO teste
		//this.label = String.format("%s", label).toLowerCase();
		this.label = uri;
		this.uri = uri;
		this.relationships = new HashMap<>();
	}

	public int getDirectHits() {
		return directHits;
	}

	public void setDirectHits(int directHits) {
		this.directHits = directHits;
	}

	public int getIndirectHits() {
		return indirectHits;
	}

	public void setIndirectHits(int indirectHits) {
		this.indirectHits = indirectHits;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		KGNode node = (KGNode) o;

		if (uri != node.uri) return false;

		return uri != null ? uri.equals(node.uri) : node.uri == null;
	}

		@Override
		public int hashCode() {
		       int result = uri != null ? uri.hashCode() : 0;
		       result = 31 * result;
		       return result;
		}
}