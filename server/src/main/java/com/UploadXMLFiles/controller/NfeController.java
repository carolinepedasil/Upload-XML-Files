@RestController
@RequestMapping("/api/nfe")
public class NfeController {
    @Autowired
    private NfeService nfeService;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadXML(@RequestParam("file") MultipartFile file) {
        nfeService.processXML(file);
        return ResponseEntity.ok("Upload realizado com sucesso!");
    }

    @GetMapping("/list")
    public ResponseEntity<List<NfeData>> getAllNfeData() {
        List<NfeData> nfeDataList = nfeService.getAllNfeData();
        return ResponseEntity.ok(nfeDataList);
    }
}
