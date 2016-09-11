
var fs = require('fs');

var gulp = require('gulp');
var sass = require('gulp-sass');
var sourcemaps = require('gulp-sourcemaps');

var _ = require('lodash');

var sourceWebappDir = 'src/main/webapp';
var buildWebappDir = 'build/inplaceWebapp';

var stylesSrcDir = 'src/main/webapp/style';
var stylesDestDir =  buildWebappDir + '/style';

gulp.task('sass', function() {

    return gulp.src(stylesSrcDir + '/*.scss')
        .pipe(sourcemaps.init())
        .pipe(sass({ outputStyle: 'compressed' }).on('error', sass.logError))
        .pipe(sourcemaps.write('./maps'))
        .pipe(gulp.dest(stylesDestDir) );

});

gulp.task('copyapp', ['sass'], function() {

    return gulp.src(sourceWebappDir + '/**/*')
        .pipe(gulp.dest(buildWebappDir));

});

gulp.task('watch', function () {
    gulp.watch(sourceWebappDir + '/**', ['copyapp']);
});

/* ng2 section */

var execV = require('exec-with-verify');

var ng2Apps = [ { src: 'src/main/js/product-mgr', dest: '/admin/product/app' } ];

var ngBuildPath = '../../../../' + buildWebappDir;

gulp.task('ng:install', function() {

    var configs = ng2Apps.map(function(app) {
        return { cmd: 'npm install', cwd: app };
    });

    return execV.execWithVerify(configs);
});

gulp.task('ng:buildDev', function() {
    return buildNgApps(false);
});

gulp.task('ng:buildProd', [ 'ng:install'], function() {
    return buildNgApps(true);
});

gulp.task('ng:distProd', ['ng:buildProd'], function() {

    _.each(ng2Apps, writeScriptJsp);

});

gulp.task('ng:distDev', ['ng:buildDev'], function() {

    _.each(ng2Apps, writeScriptJsp);

});

/*
 *  exec build via angular-cli
 *  ng build --prod --output-path=../../../../build/inplaceWebapp/admin/product/app
 *
 */

function buildNgApps(isProd, watch) {

    var execConfig = ng2Apps.map(function(app) {

        var outputPath = ' --output-path=' +  ngBuildPath + app.dest;

        var cmd = 'ng build ' + (isProd ? ' --prod ' : ' ') + (watch ? ' --watch ':'') + outputPath;
        return { cmd: cmd, cwd: app.src };
    });

    return execV.execWithVerify(execConfig);
}

/*
 *  writes script.jsp file with HTML script tags to point to app scripts
 */

function writeScriptJsp(app) {

    var appDir = buildWebappDir + app.dest;
    var parentDir = appDir.substr(0,appDir.lastIndexOf('/'));

    var files = fs.readdirSync(appDir);

    var scriptTags = _(files)
        .filter(function(file) { return _.endsWith(file, '.js'); })
        .map(function (file) {
            return '<script src="app/' + file + '"></script>';
        }).join('\n');

    var scriptsFile = parentDir + '/scripts.jsp';
    fs.writeFileSync(scriptsFile, scriptTags);
}

/* all */

// gulp.task('default', [ 'copyapp' ], function() { });
// gulp.task('default', [ 'copyapp', 'ng:distProd' ], function() { });
gulp.task('default', [ 'copyapp', 'ng:distDev' ], function() { });