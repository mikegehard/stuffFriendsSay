//
//  ContentView.swift
//  StuffFriendsSay
//
//  Created by Mike Gehard on 3/10/20.
//  Copyright © 2020 Mike Gehard. All rights reserved.
//

import SwiftUI
import platforms

struct ContentView: View {
    var body: some View {
        Text("Hello, from \(Platform().name)")
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
