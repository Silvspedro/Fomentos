package model;

public class JavaBeans {
    private String id_usuario;
    private String email_usuario;
    private String senha_usuario;
    private String confirSenha;
    private String nome_usuario;
    private String cpf_usuario;
    private String cpf_compra;
    

    public JavaBeans() {
        super();
    }

    public JavaBeans(String ID_USUARIO, String NOME_USUARIO, String EMAIL_USUARIO, String SENHA_USUARIO,String CPF_USUARIO,String CPF_COMPRA ) {
        super();
        this.id_usuario = ID_USUARIO;
        this.nome_usuario = NOME_USUARIO;
        this.email_usuario = EMAIL_USUARIO;
        this.senha_usuario = SENHA_USUARIO;
        this.cpf_usuario = CPF_USUARIO;
        this.cpf_compra = CPF_COMPRA;
    }

    public String getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(String id_usuario) {
        if (id_usuario != null && !id_usuario.isEmpty()) {
            this.id_usuario = id_usuario;
        }
    }

    public String getEmail_usuario() {
        return email_usuario;
    }

    public void setEmail_usuario(String email_usuario) {
        if (email_usuario != null && !email_usuario.isEmpty()) {
            this.email_usuario = email_usuario;
        } else {
            throw new IllegalArgumentException("O campo email_usuario é obrigatório");
        }
    }

    public String getSenha_usuario() {
        return senha_usuario;
    }

    public void setSenha_usuario(String senha_usuario) {
        if (senha_usuario != null && !senha_usuario.isEmpty()) {
            this.senha_usuario = senha_usuario;
        } else {
            throw new IllegalArgumentException("O campo senha_usuario é obrigatório");
        }
    }

    public String getConfirSenha() {
		return confirSenha;
	}

    public void setConfirSenha(String confirSenha) {
        if (confirSenha != null && !confirSenha.isEmpty()) {
            this.confirSenha = confirSenha;
        } else {
            throw new IllegalArgumentException("O campo senha_usuario é obrigatório");
        }
    }

	public String getNome_usuario() {
        return nome_usuario;
    }

    public void setNome_usuario(String nome_usuario) {
        if (nome_usuario != null && !nome_usuario.isEmpty()) {
            this.nome_usuario = nome_usuario;
        } else {
            throw new IllegalArgumentException("O campo nome_usuario é obrigatório");
        }
    }

	public String getCpf_usuario() {
		return cpf_usuario;
	}

	public void setCpf_usuario(String cpf_usuario) {
		this.cpf_usuario = cpf_usuario;
	}

	public String getCpf_compra() {
		return cpf_compra;
	}

	public void setCpf_compra(String cpf_compra) {
		this.cpf_compra = cpf_compra;
	}
   
	
    
}

	

	