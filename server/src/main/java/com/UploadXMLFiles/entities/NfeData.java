@Entity
public class NfeData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String dhEmi;
    private String nNF;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDhEmi() {
        return this.dhEmi;
    }

    public void setDhEmi(String dhEmi) {
        this.dhEmi = dhEmi;
    }

    public String getNNF() {
        return this.nNF;
    }

    public void setNNF(String nNF) {
        this.nNF = nNF;
    }

}
