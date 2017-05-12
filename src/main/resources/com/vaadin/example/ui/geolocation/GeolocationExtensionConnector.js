com_vaadin_example_ui_geolocation_GeolocationExtension = function () {

    var self = this;

    this.askLocation = function () {
        return navigator.geolocation.getCurrentPosition(function (result) {
                self.geolocationSuccess(result.coords.latitude, result.coords.longitude);
            }, this.geoLocationFail
        );
    };
};