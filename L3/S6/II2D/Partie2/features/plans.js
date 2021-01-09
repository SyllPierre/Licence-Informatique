DetectionPlan = function (args) {
    this.seuil = args.seuil;
    this.r0 = -1;
    this.g0 = -1;
    this.b0 = -1;
};

DetectionPlan.prototype.process = function (imageData) {
    var r = 0;
    var g = 0;
    var b = 0;
    var a = 0;
    var pixels = imageData.data;
    for (var x = 0; x < imageData.width; x++) {
        for (var y = 0; y < imageData.height; y++) {
            var pos = (y * imageData.width + x) << 2;

            r += pixels[pos + 0];
            g += pixels[pos + 1];
            b += pixels[pos + 2];
            a += pixels[pos + 3];
        }
    }

    var allPixels = imageData.width * imageData.height;
    var r1 = Math.floor(r / allPixels);
    var g1 = Math.floor(g / allPixels);
    var b1 = Math.floor(b / allPixels);

    if (this.r0 === -1) {
        this.r0 = r1;
        this.g0 = g1;
        this.b0 = b1;
    } else {
        var dist = Math.sqrt(
            (this.r0 - r1) * (this.r0 - r1) +
            (this.b0 - b1) * (this.b0 - b1) +
            (this.g0 - g1) * (this.g0 - g1)
        );
        if (dist >= this.seuil) {
            console.log(`dist : ${dist} > ${this.seuil}`);
        }
        this.r0 = r1;
        this.g0 = g1;
        this.b0 = b1;
    }
};
