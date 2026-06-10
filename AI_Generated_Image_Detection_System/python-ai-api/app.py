from flask import Flask, request, jsonify
from flask_cors import CORS
from PIL import Image
import random
import io

app = Flask(__name__)
CORS(app)

@app.route("/predict", methods=["POST"])
def predict():
    if "image" not in request.files:
        return jsonify({"error": "No image uploaded"}), 400

    image_file = request.files["image"]

    try:
        image = Image.open(image_file.stream).convert("RGB")

        # Temporary realistic placeholder.
        # Later we will replace this with the real pretrained AI model.
        width, height = image.size
        pixel_count = width * height

        if pixel_count > 500000:
            prediction = "AI Generated"
            confidence = round(random.uniform(75, 95), 2)
        else:
            prediction = "Real Image"
            confidence = round(random.uniform(70, 90), 2)

        return jsonify({
            "prediction": prediction,
            "confidence": confidence
        })

    except Exception as e:
        return jsonify({"error": str(e)}), 500

@app.route("/", methods=["GET"])
def home():
    return "Python AI API is running"

if __name__ == "__main__":
    app.run(debug=True, port=5000)