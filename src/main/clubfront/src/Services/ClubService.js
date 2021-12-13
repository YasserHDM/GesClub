import axios from 'axios';



class ClubService {

    getClubs() {
        return axios.get("http://localhost:8080/api/club");
    }

    createClub(club) {
        return axios.post("http://localhost:8080/api/createClub", club);
    }

    
}

export default new ClubService()