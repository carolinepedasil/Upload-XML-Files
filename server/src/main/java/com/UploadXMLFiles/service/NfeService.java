@Service
public class NfeService {
    @Autowired
    private NfeDataRepository nfeDataRepository;

    public void processXML(MultipartFile file) {
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(file.getInputStream());

            String dhEmi = doc.getElementsByTagName("dhEmi").item(0).getTextContent();
            String nNF = doc.getElementsByTagName("nNF").item(0).getTextContent();

            NfeData nfeData = new NfeData();
            nfeData.setDhEmi(dhEmi);
            nfeData.setNNF(nNF);
            nfeDataRepository.save(nfeData);

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao processar o arquivo XML");
        }
    }

    public List<NfeData> getAllNfeData() {
        return nfeDataRepository.findAll();
    }
}
