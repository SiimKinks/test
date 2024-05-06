import SwiftUI

public protocol ViewStateRenderer {
    associatedtype OutputType: View
    associatedtype ViewStateType
    
    func render(viewState: ViewStateType) -> OutputType
}
