package model;
import java.util.List;

public class User {

	private Integer Idcollum;
	private String Namecollum;
	private String CpfCollum;
	private String EmailCollum;

	public Integer getId() 
	{
		return Idcollum;	
	}

	public String getNome() 
	{
		return Namecollum;
	}
	
	public void setNome (String nome) 
	{
	Namecollum = nome;		
	}
	
	public String getCpf() 
	{
	   return  CpfCollum;
	}
	
	public void setCpf (String cpf)
	{	
		CpfCollum = cpf;
	}
	
	public String getEmail() 
	{
	   return  EmailCollum;
	}
	
	public void setEmail (String email)
	{
		EmailCollum = email;
	}

	@Override
	public String toString() 
	{
		return "User [Cpf=" + CpfCollum + ", Email=" + EmailCollum + ", Nome=" + Namecollum + "]";
	}
	
	public User(Integer id,String  cpf , String  email,String  nome )
	{
		super();
		
		Idcollum = id;
		CpfCollum =cpf;
		EmailCollum = email;
		Namecollum = nome;
	}
	
	public User() 
	{
		
	}
	
	public User findUser (Integer id,List<User>users)
	{		
		{
			for (User user :users)
			{
				if (user.getId().equals(Idcollum))
				{
					return user;
				}			
			}		
			return null;
		}	
	}	
	
}
