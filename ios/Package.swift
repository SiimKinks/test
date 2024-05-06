// swift-tools-version: 5.7

import PackageDescription

let package = Package(
    name: "ios",
    platforms: [.iOS(.v16)],
    dependencies: [
        .package(
            url: "https://github.com/ReactiveX/RxSwift.git",
            exact: "6.6.0"
        )
    ],
    targets: [
        .executableTarget(
            name: "ios",
            dependencies: [
                .product(name: "RxSwift", package: "RxSwift"),
                .product(name: "RxRelay", package: "RxSwift"),
            ]),
        .testTarget(
            name: "iosTests",
            dependencies: [
                "ios",
                .product(name: "RxSwift", package: "RxSwift")
            ]),
    ]
)
