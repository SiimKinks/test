import RxSwift

final class AccountDetailsPresenter<View: AccountDetailsView>: Presenter<View> {
    override func bindActions() {
        Observable.just(ViewState())
            .subscribeViewState(to: self)
    }
}
