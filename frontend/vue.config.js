module.exports = {
    // 개발 서버 설정
    devServer: {
        // 프록시 설정
        proxy: {
            // 프록시 요청을 보낼 api의 시작 부분
            '/parkinglot': {
                // 프록시 요청을 보낼 서버의 주소
                target: 'http://localhost:8080',
                changeOrigin: true // cross origin 허용
            }
        }
    }
};