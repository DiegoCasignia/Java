package traductor;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.AdvancedPlayer;
import org.json.JSONArray;
import org.json.JSONObject;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;

/**
 *
 * @author Diego Casignia
 */
public class Traductor {

    TraduccionObj traduccionObj;

    public Traductor(TraduccionObj traduccionObj) {
        this.traduccionObj = traduccionObj;
    }

    public String traducirTexto() {
        HttpResponse<String> response = Unirest.post("https://text-translator-v2.p.rapidapi.com/api/translate/text")
                .header("content-type", "application/json")
                .header("X-RapidAPI-Key", "KEY") //Usted debe registrarse en la API para obtener su KEY
                .header("X-RapidAPI-Host", "text-translator-v2.p.rapidapi.com")
                .body("{\r\n    \"text\": \"" + traduccionObj.getTextoOriginal() + "\",\r\n    \"source\": \"" + traduccionObj.getIdiomaOrigen() + "\",\r\n    \"target\": \"" + traduccionObj.getIdiomaDestino() + "\"\r\n}")
                .asString();

        String responseBody = response.getBody();
        JSONObject jsonResponse = new JSONObject(responseBody);
        JSONArray translationsArray = jsonResponse.getJSONObject("payload").getJSONArray("translations");
        String translatedText = translationsArray.getJSONObject(0).getString("translation");
        return translatedText;
    }

    public String generarUrlImagen(String promptString) {
        String imageUrl = "";
        HttpResponse<String> response = Unirest.post("https://animimagine-ai.p.rapidapi.com/generateImage")
                .header("content-type", "application/json")
                .header("Content-Type", "application/json")
                .header("X-RapidAPI-Key", "KEY") //Usted debe registrarse en la API para obtener su KEY
                .header("X-RapidAPI-Host", "animimagine-ai.p.rapidapi.com")
                .body("{\r\n    \"selected_model_id\": \"anything-v5\",\r\n    \"selected_model_bsize\": \"512\",\r\n    \"prompt\": \"" + promptString + "\"\r\n}")
                .asString();

        if (response.getStatus() == 200) {
            JSONObject jsonResponse = new JSONObject(response.getBody());
            imageUrl = jsonResponse.getString("imageUrl");
        }
        return imageUrl;
    }

    public void escucharTexto() throws JavaLayerException {
        HttpResponse<String> response = null;
        if ("en".equals(traduccionObj.getIdiomaDestino())) {
            response = Unirest.post("https://realistic-text-to-speech.p.rapidapi.com/v3/generate_voice_over_v2")
                    .header("content-type", "application/json")
                    .header("X-RapidAPI-Key", "KEY") //Usted debe registrarse en la API para obtener su KEY
                    .header("X-RapidAPI-Host", "realistic-text-to-speech.p.rapidapi.com")
                    .body("{\r\n    \"voice_obj\": {\r\n        \"id\": 2014,\r\n        \"voice_id\": \"en-US-Neural2-A\",\r\n        \"gender\": \"Male\",\r\n        \"language_code\": \"en-US\",\r\n        \"language_name\": \"US English\",\r\n        \"voice_name\": \"John\",\r\n        \"sample_text\": \"Hello, hope you are having a great time making your video.\",\r\n        \"sample_audio_url\": \"https://s3.ap-south-1.amazonaws.com/invideo-uploads-ap-south-1/speechen-US-Neural2-A16831901130600.mp3\",\r\n        \"status\": 2,\r\n        \"rank\": 0,\r\n        \"type\": \"google_tts\",\r\n        \"isPlaying\": false\r\n    },\r\n    \"json_data\": [\r\n        {\r\n            \"block_index\": 0,\r\n            \"text\": \"" + traduccionObj.getTextoTraducido() + "\"\r\n        }\r\n    ]\r\n}")
                    .asString();
        }
        if ("es".equals(traduccionObj.getIdiomaDestino())) {
            response = Unirest.post("https://realistic-text-to-speech.p.rapidapi.com/v3/generate_voice_over_v2")
                    .header("content-type", "application/json")
                    .header("X-RapidAPI-Key", "KEY") //Usted debe registrarse en la API para obtener su KEY
                    .header("X-RapidAPI-Host", "realistic-text-to-speech.p.rapidapi.com")
                    .body("{\r\n    \"voice_obj\": {\r\n        \"id\": 2023,\r\n        \"voice_id\": \"es-ES-Neural2-A\",\r\n        \"gender\": \"Female\",\r\n        \"language_code\": \"es-ES\",\r\n        \"language_name\": \"Spanish\",\r\n        \"voice_name\": \"Alba\",\r\n        \"sample_text\": \"Hola, espero que estés teniendo un gran tiempo haciendo tu video.\",\r\n        \"sample_audio_url\": \"https://s3.ap-south-1.amazonaws.com/invideo-uploads-ap-south-1/speeches-ES-Neural2-A16831901130100.mp3\",\r\n        \"status\": 2,\r\n        \"rank\": 0,\r\n        \"type\": \"google_tts\",\r\n        \"isPlaying\": false\r\n    },\r\n    \"json_data\": [\r\n        {\r\n            \"block_index\": 0,\r\n            \"text\": \"" + traduccionObj.getTextoTraducido() + "\"\r\n        }\r\n    ]\r\n}")
                    .asString();
        }
        String jsonResponse = response.getBody();
        JSONArray jsonArray = new JSONArray(jsonResponse);
        JSONObject jsonObject = jsonArray.getJSONObject(0);
        String enlace = jsonObject.getString("link");
        try {
            // Crea un objeto de URL con el enlace del audio
            URL audioURL = new URL(enlace);
            // Abre una conexión con el servidor web
            URLConnection audioConnection = audioURL.openConnection();
            // Obtiene un flujo de entrada desde la conexión
            BufferedInputStream audioStream = new BufferedInputStream(audioConnection.getInputStream());

            // Crea un reproductor avanzado de JLayer
            AdvancedPlayer player = new AdvancedPlayer(audioStream);

            // Inicia la reproducción del audio
            player.play();

        } catch (IOException | JavaLayerException e) {
            e.printStackTrace();
        }
    }
}
