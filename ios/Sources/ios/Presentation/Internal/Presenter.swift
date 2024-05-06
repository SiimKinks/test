import RxRelay
import RxSwift

open class Presenter<View: ViewStateRenderer> {
    typealias ViewState = View.ViewStateType
    var isBound = false
    private var subscribeViewStateMethodCalled = false
    private let viewStateRelay = BehaviorRelay<ViewState?>(value: nil)
    private var disposables: DisposeBag? = DisposeBag()

    init() {}

    open func bindActions() {
        fatalError("bindActions not implemented!. Add\n\npublic override func bindActions() {}\n\n")
    }

    final func internalBindActions() {
        bindActions()
        isBound = true
    }

    final func internalUnbind() {
        isBound = false
        disposables = nil
    }


    final func subscribeViewState(_ viewStateObservable: Observable<ViewState>) {
        guard !subscribeViewStateMethodCalled else {
            fatalError("subscribeViewState function is only allowed to be called once")
        }
        subscribeViewStateMethodCalled = true
        disposables?.insert(viewStateObservable.bind(to: viewStateRelay))
    }

    final func attachView(
        view: View,
        onViewState: @escaping (ViewState?) -> Void
    ) {
        disposables?.insert(viewStateRelay
            .observe(on: MainScheduler.instance)
            .subscribe(onNext: onViewState)
        )
    }
}

extension Observable {
    func subscribeViewState<PresenterImpl, View>(
        to presenter: PresenterImpl
    ) where PresenterImpl: Presenter<View>, View: ViewStateRenderer {
        guard let self = self as? Observable<PresenterImpl.ViewState> else {
            fatalError("subscribeViewState stream elements must conform to \(PresenterImpl.ViewState.self)")
        }
        presenter.subscribeViewState(self)
    }
}
