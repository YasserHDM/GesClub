import axios from 'axios';


const API_URL = "http://localhost:8080/api/club"

class ClubService {

    getClubs() {
        return axios.get(API_URL);
    }

    
}

export default new ClubService()