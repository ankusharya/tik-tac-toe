if (process.env.NODE_ENV === "production") {
    const opt = require("./tik-tac-toe-opt.js");
    opt.main();
    module.exports = opt;
} else {
    var exports = window;
    exports.require = require("./tik-tac-toe-fastopt-entrypoint.js").require;
    window.global = window;

    const fastOpt = require("./tik-tac-toe-fastopt.js");
    fastOpt.main()
    module.exports = fastOpt;

    if (module.hot) {
        module.hot.accept();
    }
}
