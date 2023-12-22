package TestPOJO;

public class CreateRepoPOJO {

	public String name;
	public String description;
	public String link;
	public boolean  VarData;
    private String owner;
	private String repo;
	public String getName() {
		return name;
		
	}
	
	public void setName(String name)
	{
		this.name=name;
	
	}
	
	public String getdescription() {
		return description;
	}
	public void  setdescription(String desc) {
		this.description= desc;
		
	}
	public String getLink() {
		return link;
		
	}
	public void setLink(String link) {
		this.link =link;
	}
	public boolean isVarData() {
		return VarData;
	}
	
    public String getOwner() {
			return owner;
		}

	public void setOwner(String owner) {
			this.owner = owner;
		}

	public String getRepo() {
			return repo;
		}

	public void setRepo(String repo) {
			this.repo = repo;
		}
	}

