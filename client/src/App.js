import React, { useState, useEffect } from 'react';
import axios from 'axios';

function App() {
    const [nfeDataList, setNfeDataList] = useState([]);
    const [file, setFile] = useState(null);

    useEffect(() => {
        axios.get('/api/nfe/list')
            .then(response => setNfeDataList(response.data))
            .catch(error => console.error(error));
    }, []);

    const handleFileUpload = (event) => {
        const uploadedFile = event.target.files[0];
        setFile(uploadedFile);
    };

    const handleUpload = () => {
        const formData = new FormData();
        formData.append('file', file);

        axios.post('/api/nfe/upload', formData)
            .then(response => {
                console.log(response.data);
                axios.get('/api/nfe/list')
                    .then(response => setNfeDataList(response.data))
                    .catch(error => console.error(error));
            })
            .catch(error => console.error(error));
    };

    return (
        <div>
            <input type="file" onChange={handleFileUpload} />
            <button onClick={handleUpload}>Enviar</button>

            <h2>Listagem de Dados</h2>
            <ul>
                {nfeDataList.map((item) => (
                    <li key={item.id}>
                        {item.dhEmi} - {item.nNF}
                    </li>
                ))}
            </ul>
        </div>
    );
}

export default App;