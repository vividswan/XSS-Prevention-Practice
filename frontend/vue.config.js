module.exports = {
  "outputDir": "../Backend/src/main/resources/static",
  "devServer": {
    "proxy": {
      "/api": {
        "target": "http://localhost:5000"
      }
    }
  },
  "transpileDependencies": [
    "vuetify"
  ]
}